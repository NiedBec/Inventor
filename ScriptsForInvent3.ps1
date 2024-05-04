$b = $PSScriptRoot
Write-Host "Путь исполнения скрипта" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "Проверка компьютера " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comps" + "\$a"
$StartTime = (Get-Date)




if (Test-Path -Path $UniversalPath){
    Write-Host "Директория уже создана" -ForegroundColor Red
}
else{
    Write-Host "Создается директория" -ForegroundColor Red
    New-Item -Path $UniversalPath -ItemType Directory
}





"Компьютер " + "$a" | out-file -Encoding UTF8 "$UniversalPath.csv"
Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath.csv" -append 

Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath\InformationOS.CSV" -append 







Write-Host "Определение UUID " -ForeGroundColor Green $a

Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath\UUID.CSV" -append







Write-Host "Определение данных о процессоре " -ForeGroundColor Green $a

"Процессор" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\Processor.csv" -append





Write-Host "Определение данных о материнской плате " -ForeGroundColor Green $a

"Материнская плата" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\MotherBoard.csv" -append





Write-Host "Определение данных о жестких дисках " -ForeGroundColor Green $a

"Жесткие диски" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\HDD.csv" -append







Write-Host "Определение данных о логических дисках " -ForeGroundColor Green $a

"Логические диски" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\LogicalDrives.csv" -append








Write-Host "Определение данных об оперативной памяти " -ForeGroundColor Green $a

"Оперативная память" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail, MemoryType |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append
"MemoryDevices" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
ConvertTo-csv -NoTypeInformation | 
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail, MemoryType |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\RAM.csv" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
ConvertTo-csv -NoTypeInformation | 
out-file -Encoding UTF8 "$UniversalPath\RAMInfo.csv" -append






Write-Host "Определение данных о видеокарте " -ForeGroundColor Green $a

"Видеокарта" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_videoController |
Select-Object name, VideoProcessor |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_videoController |
Select-Object name, VideoProcessor |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\GPU.csv" -append





Write-Host "Определение данных о сетевой карте " -ForeGroundColor Green $a

"Сетевая карта" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
"Сетевая карта" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
$OS=Get-WmiObject Win32_OperatingSystem | foreach {$_.caption}
if ($OS -eq "Microsoft Windows 2000 Professional")
{
Get-WmiObject Win32_NetworkAdapterConfiguration -Filter "DHCPEnabled=True" |
Select-Object caption,MACaddress |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append
}
else
{
Get-WmiObject Win32_NetworkAdapter -Filter "NetConnectionStatus>0" |
Select-Object name, AdapterType, MACAddress |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append
}

$OS=Get-WmiObject Win32_OperatingSystem | foreach {$_.caption}
if ($OS -eq "Microsoft Windows 2000 Professional")
{
Get-WmiObject Win32_NetworkAdapterConfiguration -Filter "DHCPEnabled=True" |
Select-Object caption,MACaddress |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\LANCard.csv" -append
}
else
{
Get-WmiObject Win32_NetworkAdapter -Filter "NetConnectionStatus>0" |
Select-Object name, AdapterType, MACAddress |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\LANCard.csv" -append
}





Write-Host "Определение сетевой информации " -ForeGroundColor Green $a

"Сетевая информация" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-NetIPAddress| Select-Object PrefixOrigin, SuffixOrigin, Type, Store, AddressFamily, AddressState, ProtocolIFType, IPv4Address, IPv6Address, InterfaceAlias, InterfaceIndex, IPAddress | ConvertTo-Csv -NoTypeInformation |       
out-file -Encoding UTF8  "$UniversalPath.csv" -append

Get-NetIPAddress| Select-Object PrefixOrigin, SuffixOrigin, Type, Store, AddressFamily, AddressState, ProtocolIFType, IPv4Address, IPv6Address, InterfaceAlias, InterfaceIndex, IPAddress | ConvertTo-Csv -NoTypeInformation |       
out-file -Encoding UTF8 "$UniversalPath\NetInfo.csv" -append







Write-Host "Определение списка установленного ПО " -ForeGroundColor Green $a

"Список установленного ПО" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | ConvertTo-csv -NoTypeInformation |     
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | ConvertTo-csv -NoTypeInformation |     
out-file -Encoding UTF8 "$UniversalPath\Programs.csv" -append



$EndTime = (Get-Date)
$TotalTime = $EndTime-$StartTime

Write-Host "Скрипт отработал за " $TotalTime.TotalSeconds " секунд" -ForeGroundColor Green

Write-Host "Запись DxDiag файла " -ForeGroundColor Green $a
dxdiag /whql:off /x $UniversalPath+dxdiag.xml 
pause