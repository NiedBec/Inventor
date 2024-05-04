$b = $PSScriptRoot
Write-Host "���� ���������� �������" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "�������� ���������� " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comps" + "\$a"
$StartTime = (Get-Date)




if (Test-Path -Path $UniversalPath){
    Write-Host "���������� ��� �������" -ForegroundColor Red
}
else{
    Write-Host "��������� ����������" -ForegroundColor Red
    New-Item -Path $UniversalPath -ItemType Directory
}





"��������� " + "$a" | out-file -Encoding UTF8 "$UniversalPath.csv"
Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath.csv" -append 

Get-WmiObject Win32_OperatingSystem | 
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath\InformationOS.CSV" -append 







Write-Host "����������� UUID " -ForeGroundColor Green $a

Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
ConvertTo-csv -NoTypeInformation | out-file -Encoding UTF8 "$UniversalPath\UUID.CSV" -append







Write-Host "����������� ������ � ���������� " -ForeGroundColor Green $a

"���������" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\Processor.csv" -append





Write-Host "����������� ������ � ����������� ����� " -ForeGroundColor Green $a

"����������� �����" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\MotherBoard.csv" -append





Write-Host "����������� ������ � ������� ������ " -ForeGroundColor Green $a

"������� �����" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\HDD.csv" -append







Write-Host "����������� ������ � ���������� ������ " -ForeGroundColor Green $a

"���������� �����" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\LogicalDrives.csv" -append








Write-Host "����������� ������ �� ����������� ������ " -ForeGroundColor Green $a

"����������� ������" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
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






Write-Host "����������� ������ � ���������� " -ForeGroundColor Green $a

"����������" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-WmiObject Win32_videoController |
Select-Object name, VideoProcessor |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-WmiObject Win32_videoController |
Select-Object name, VideoProcessor |
ConvertTo-csv -NoTypeInformation |
out-file -Encoding UTF8 "$UniversalPath\GPU.csv" -append





Write-Host "����������� ������ � ������� ����� " -ForeGroundColor Green $a

"������� �����" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
"������� �����" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
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





Write-Host "����������� ������� ���������� " -ForeGroundColor Green $a

"������� ����������" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-NetIPAddress| Select-Object PrefixOrigin, SuffixOrigin, Type, Store, AddressFamily, AddressState, ProtocolIFType, IPv4Address, IPv6Address, InterfaceAlias, InterfaceIndex, IPAddress | ConvertTo-Csv -NoTypeInformation |       
out-file -Encoding UTF8  "$UniversalPath.csv" -append

Get-NetIPAddress| Select-Object PrefixOrigin, SuffixOrigin, Type, Store, AddressFamily, AddressState, ProtocolIFType, IPv4Address, IPv6Address, InterfaceAlias, InterfaceIndex, IPAddress | ConvertTo-Csv -NoTypeInformation |       
out-file -Encoding UTF8 "$UniversalPath\NetInfo.csv" -append







Write-Host "����������� ������ �������������� �� " -ForeGroundColor Green $a

"������ �������������� ��" | out-file -Encoding UTF8 "$UniversalPath.csv" -append
Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | ConvertTo-csv -NoTypeInformation |     
out-file -Encoding UTF8 "$UniversalPath.csv" -append

Get-ItemProperty HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\* | Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | ConvertTo-csv -NoTypeInformation |     
out-file -Encoding UTF8 "$UniversalPath\Programs.csv" -append



$EndTime = (Get-Date)
$TotalTime = $EndTime-$StartTime

Write-Host "������ ��������� �� " $TotalTime.TotalSeconds " ������" -ForeGroundColor Green

Write-Host "������ DxDiag ����� " -ForeGroundColor Green $a
dxdiag /whql:off /x $UniversalPath+dxdiag.xml 
pause