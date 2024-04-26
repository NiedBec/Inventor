$b = $PSScriptRoot
Write-Host "Путь исполнения скрипта" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "Проверка компьютера " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comp" + "\$a"

"Компьютер " + "$a" | out-file  "$UniversalPath.json"
Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-Json | 
out-file "$UniversalPath.json" -append


Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-Json | out-file "$UniversalPath.json" -append


"Процессор" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"Материнская плата" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"Жесткие диски" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"Логические диски" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"Оперативная память" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail, MemoryType |
ConvertTo-Json |
out-file "$UniversalPath.json" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
ConvertTo-Json | 
out-file "$UniversalPath.json" -append

"Видеокарта" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_videoController |
Select-Object name, AdapterRAM, VideoProcessor |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"Сетевая карта" | out-file "$UniversalPath.json" -append
$OS=Get-WmiObject Win32_OperatingSystem | foreach {$_.caption}
if ($OS -eq "Microsoft Windows 2000 Professional")
{
Get-WmiObject Win32_NetworkAdapterConfiguration -Filter "DHCPEnabled=True" |
Select-Object caption,MACaddress |
ConvertTo-Json |
out-file "$UniversalPath.json" -append
}
else
{
Get-WmiObject Win32_NetworkAdapter -Filter "NetConnectionStatus>0" |
Select-Object name, AdapterType, MACAddress |
ConvertTo-Json |
out-file "$UniversalPath.json" -append
}

"Сетевая информация" | out-file "$UniversalPath.json" -append
Get-NetIPConfiguration | Format-List |          
out-file "$UniversalPath.json" -append

"Список установленного ПО" | out-file "$UniversalPath.json" -append
Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, Size, InstallDate | Format-list |          
out-file "$UniversalPath.json" -append

"Список установленного Metro ПО" | out-file "$UniversalPath.json" -append
Get-AppxPackage | format-list |
out-file "$UniversalPath.json" -append