$b = $PSScriptRoot
Write-Host "���� ���������� �������" -ForegroundColor Green  $b
$a = (Get-WmiObject win32_computersystem).DNSHostName
Write-Host "�������� ���������� " -ForeGroundColor Green $a
$UniversalPath = $b + "\Comp" + "\$a"

"��������� " + "$a" | out-file  "$UniversalPath.txt"
Get-WmiObject Win32_OperatingSystem |
select-object csname, caption, Serialnumber, Version, RegisteredUser, CountryCode |
fl @{Label="������� ���"; Expression={$_.CSname}},
@{label="������������"; Expression={$_.caption}},
@{label="������"; Expression={$_.Version}},
@{label="�������� �����"; Expression={$_.SerialNumber}},
@{label="������������������ ������������"; Expression={$_.RegisteredUser}},
@{label="��� ������ ��� �������"; Expression={$_.CountryCode}} |
out-file "$UniversalPath.txt" -append


Get-WmiObject Win32_ComputerSystemProduct | select-object UUID |
fl UUID | out-file "$UniversalPath.txt" -append


"���������" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_Processor | select-object name, SocketDesignation, Description, CurrentClockSpeed |
fl @{label="������������"; Expression={$_.name}},
@{label="������"; Expression={$_.SocketDesignation}},
@{label="��������"; Expression={$_.Description}},
@{label="������� �������� ���������� � ���"; Expression={$_.CurrentClockSpeed}} | out-file "$UniversalPath.txt" -append


"����������� �����" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_BaseBoard | select-object Manufacturer, Product, SerialNumber, Status |
fl @{label="�������������"; Expression={$_.manufacturer}},
@{label="������"; Expression={$_.Product}},
@{label="������"; Expression={$_.Status}},
@{label="�������� �����"; Expression={$_.SerialNumber}} |
out-file "$UniversalPath.txt" -append


"������� �����" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_DiskDrive | select-object Model, Partitions, Size, interfacetype |
fl @{Label="������"; Expression={$_.Model}},
@{Label="���������� ��������"; Expression={$_.Partitions}},
@{Label="������ (��)"; Expression={($_.Size/1GB).tostring("F00")}},
@{Label="���������"; Expression={$_.interfaceType}} |
out-file "$UniversalPath.txt" -append


"���������� �����" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_LogicalDisk -Filter "DriveType=3" | select-object DeviceID, FileSystem, Size, FreeSpace |
fl @{Label="������������"; Expression={$_.DeviceID}},
@{Label="�������� �������"; Expression={$_.FileSystem}},
@{Label="������ (��)"; Expression={($_.Size/1GB).tostring("F00")}},
@{Label="��������� ����� (��)"; Expression={($_.FreeSpace/1GB).tostring("F00")}} |
out-file "$UniversalPath.txt" -append


"����������� ������" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_Physicalmemory | Select-Object capacity, DeviceLocator, Manufacturer,PartNumber, SerialNumber, Tag, TypeDetail |
fl @{Label="������ (��)"; Expression={($_.capacity/1MB).tostring("F00")}},
@{Label="������������"; Expression={$_.DeviceLocator}},
@{Label="�������������"; Expression={$_.Manufacturer}},
@{Label="����� ������ (PartNumber)"; Expression={$_.PartNumber}},
@{Label="�������� �����"; Expression={$_.SerialNumber}},
@{Label="�������������"; Expression={$_.Tag}},
@{Label="����� ��������� ����������� ������ � ��"; Expression={$_.TypeDetail}} |
out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_PhysicalMemoryArray | Select-Object MemoryDevices |
fl @{Label="���������� ������ ����������� ������"; Expression={$_.MemoryDevices}} | 
out-file "$UniversalPath.txt" -append

"����������" | out-file "$UniversalPath.txt" -append
Get-WmiObject Win32_videoController |
Select-Object name, AdapterRAM, VideoProcessor |
fl @{Label="������������"; Expression={$_.name}},
@{Label="����� ������ (��)"; Expression={($_.AdapterRAM/1MB).tostring("F00")}},
@{Label="��������������"; Expression={$_.VideoProcessor}} |
out-file "$UniversalPath.txt" -append


"������� �����" | out-file "$UniversalPath.txt" -append
$OS=Get-WmiObject Win32_OperatingSystem | foreach {$_.caption}
if ($OS -eq "Microsoft Windows 2000 Professional")
{
Get-WmiObject Win32_NetworkAdapterConfiguration -Filter "DHCPEnabled=True" |
Select-Object caption,MACaddress |
fl @{Label="������������"; Expression={$_.caption}},
@{Label="MAC �����"; Expression={$_.MACAddress}} |
out-file "$UniversalPath.txt" -append
}
else
{
Get-WmiObject Win32_NetworkAdapter -Filter "NetConnectionStatus>0" |
Select-Object name, AdapterType, MACAddress |
fl @{Label="������������"; Expression={$_.name}},
@{Label="MAC �����"; Expression={$_.MACAddress}},
@{Label="���"; Expression={$_.AdapterType}} |
out-file "$UniversalPath.txt" -append
}
