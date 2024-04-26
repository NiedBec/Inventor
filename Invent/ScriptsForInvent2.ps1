$b = $PSScriptRoot
Write-Host "���� ���������� �������" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "�������� ���������� " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comp" + "\$a"

"��������� " + "$a" | out-file  "$UniversalPath.json"
Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-Json | 
out-file "$UniversalPath.json" -append


Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-Json | out-file "$UniversalPath.json" -append


"���������" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"����������� �����" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"������� �����" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"���������� �����" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"����������� ������" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail, MemoryType |
ConvertTo-Json |
out-file "$UniversalPath.json" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
ConvertTo-Json | 
out-file "$UniversalPath.json" -append

"����������" | out-file "$UniversalPath.json" -append
Get-WmiObject Win32_videoController |
Select-Object name, AdapterRAM, VideoProcessor |
ConvertTo-Json |
out-file "$UniversalPath.json" -append


"������� �����" | out-file "$UniversalPath.json" -append
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

"������� ����������" | out-file "$UniversalPath.json" -append
Get-NetIPConfiguration | Format-List |          
out-file "$UniversalPath.json" -append

"������ �������������� ��" | out-file "$UniversalPath.json" -append
Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, Size, InstallDate | Format-list |          
out-file "$UniversalPath.json" -append

"������ �������������� Metro ��" | out-file "$UniversalPath.json" -append
Get-AppxPackage | format-list |
out-file "$UniversalPath.json" -append