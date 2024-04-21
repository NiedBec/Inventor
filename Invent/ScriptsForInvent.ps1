$b = $PSScriptRoot
Write-Host "Путь исполнения скрипта" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "Проверка компьютера " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comp" + "\$a"

"Компьютер " + "$a" | out-file  "$UniversalPath.txt"
Get-WmiObject Win32_OperatingSystem |
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
fl @{Label="Сетевое имя"; Expression={$_.CSname}},
@{label="Наименование"; Expression={$_.caption}},
@{label="Версия"; Expression={$_.Version}},
@{label="Серийный номер"; Expression={$_.SerialNumber}},
@{label="Зарегестрированный пользователь"; Expression={$_.RegisteredUser}},
@{label="Код страны или региона"; Expression={$_.CountryCode}} |
out-file "$UniversalPath.txt" -append


Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
fl UUID | out-file "$UniversalPath.txt" -append


"Процессор" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
fl @{label="Наименование"; Expression={$_.name}},
@{label="Разъем"; Expression={$_.SocketDesignation}},
@{label="Описание"; Expression={$_.Description}},
@{label="Текущая скорость процессора в МГц"; Expression={$_.CurrentClockSpeed}} | out-file "$UniversalPath.txt" -append


"Материнская плата" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
fl @{label="Производитель"; Expression={$_.manufacturer}},
@{label="Модель"; Expression={$_.Product}},
@{label="Статус"; Expression={$_.Status}},
@{label="Серийный номер"; Expression={$_.SerialNumber}} |
out-file "$UniversalPath.txt" -append


"Жесткие диски" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
fl @{Label="Модель"; Expression={$_.Model}},
@{Label="Количество разделов"; Expression={$_.Partitions}},
@{Label="Размер (гб)"; Expression={($_.Size/1GB).tostring("F00")}},
@{Label="Интерфейс"; Expression={$_.interfaceType}} |
out-file "$UniversalPath.txt" -append


"Логические диски" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
fl @{Label="Наименование"; Expression={$_.DeviceID}},
@{Label="Файловая система"; Expression={$_.FileSystem}},
@{Label="Размер (гб)"; Expression={($_.Size/1GB).tostring("F00")}},
@{Label="Свободное место (гб)"; Expression={($_.FreeSpace/1GB).tostring("F00")}} |
out-file "$UniversalPath.txt" -append


"Оперативная память" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail |
fl @{Label="Размер (мб)"; Expression={($_.capacity/1MB).tostring("F00")}},
@{Label="Расположение"; Expression={$_.DeviceLocator}},
@{Label="Производитель"; Expression={$_.Manufacturer}},
@{Label="Номер детали (PartNumber)"; Expression={$_.PartNumber}},
@{Label="Серийный номер"; Expression={$_.SerialNumber}},
@{Label="Идентификатор"; Expression={$_.Tag}},
@{Label="Общая доступная Оперативная память в МБ"; Expression={$_.TypeDetail}} |
out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
fl @{Label="Количество слотов оперативной памяти"; Expression={$_.MemoryDevices}} | 
out-file "$UniversalPath.txt" -append

"Видеокарта" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_videoController |
Select-Object name, AdapterRAM, VideoProcessor |
fl @{Label="Наименование"; Expression={$_.name}},
@{Label="Объем памяти (мб)"; Expression={($_.AdapterRAM/1MB).tostring("F00")}},
@{Label="Видеопроцессор"; Expression={$_.VideoProcessor}} |
out-file "$UniversalPath.txt" -append


"Сетевая карта" | out-file "$UniversalPath.txt" -append
$OS=Get-WmiObject Win32_OperatingSystem | foreach {$_.caption}
if ($OS -eq "Microsoft Windows 2000 Professional")
{
Get-WmiObject Win32_NetworkAdapterConfiguration -Filter "DHCPEnabled=True" |
Select-Object caption,MACaddress |
fl @{Label="Наименование"; Expression={$_.caption}},
@{Label="MAC адрес"; Expression={$_.MACAddress}} |
out-file "$UniversalPath.txt" -append
}
else
{
Get-WmiObject Win32_NetworkAdapter -Filter "NetConnectionStatus>0" |
Select-Object name, AdapterType, MACAddress |
fl @{Label="Наименование"; Expression={$_.name}},
@{Label="MAC адрес"; Expression={$_.MACAddress}},
@{Label="Тип"; Expression={$_.AdapterType}} |
out-file "$UniversalPath.txt" -append
}
