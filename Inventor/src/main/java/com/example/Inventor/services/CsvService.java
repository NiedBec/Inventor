package com.example.Inventor.services;

import com.example.Inventor.models.*;
import com.example.Inventor.repo.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class CsvService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private InformationOSRepository informationOSRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private HDDRepository hddRepository;
    @Autowired
    private LANCardRepository lanCardRepository;
    @Autowired
    private LogicalDriveRepository logicalDriveRepository;
    @Autowired
    private MotherboardRepository motherboardRepository;
    @Autowired
    private NetInfoRepository netInfoRepository;
    @Autowired
    private ProcessorRepository processorRepository;
    @Autowired
    private ProgramsRepository programsRepository;
    @Autowired
    private RamInfoRepository ramInfoRepository;
    @Autowired
    private RAMRepository ramRepository;
    @Autowired
    private UUIDRepository uuidDRepository;
    @Autowired
    private GPURepository gpuRepository;



    public void processCsv(MultipartFile file) {
        Report report = new Report();
        report.setDateTime(new Date());
        reportRepository.save(report);
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                 // Обработка и сохранение данных в соответствующие таблицы
                if (nextRecord[0].equals("csname")) {

                    // Обработка информации для InformationOS
                    InformationOS informationOS = new InformationOS();
                    String[] tmpRecord = csvReader.readNext();
                    informationOS.setCsname(tmpRecord[0]);
                    informationOS.setCaption(tmpRecord[1]);
                    informationOS.setSerialNumber(tmpRecord[2]);
                    informationOS.setVersion(tmpRecord[3]);
                    informationOS.setRegisteredUser(tmpRecord[4]);
                    informationOS.setCountryCode(tmpRecord[5]);
                    informationOS.setreportId(report); // Берем на основе созданного репорта
                    informationOSRepository.save(informationOS);

                    // Обработка информации для Location
                    Location location = new Location();
                    location.setCabinet("Изменить значение по умолчанию может только Администратор БД");
                    location.setCity("Изменить значение по умолчанию может только Администратор БД");
                    location.setHouse("Изменить значение по умолчанию может только Администратор БД");
                    location.setStreet("Изменить значение по умолчанию может только Администратор БД");
                    location.setreportId(report); // Берем на основе созданного репорта
                    locationRepository.save(location);
                    continue;
                }

                if (nextRecord[0].equals("UUID")) {
                    // Обработка информации для UUID
                    String[] tmpRecord = csvReader.readNext();
                    UUIDEntity uuidEntity = new UUIDEntity();
                    uuidEntity.setUuid(UUID.fromString(tmpRecord[0]));
                    uuidEntity.setreportId(report);
                    uuidDRepository.save(uuidEntity);
                    continue;
                }

                if (nextRecord[0].equals("Процессор")) {
                    // Обработка информации о процессоре
                    String[] tmpRecord = csvReader.readNext();
                    tmpRecord = csvReader.readNext();
                    Processor processor = new Processor();
                    processor.setName(tmpRecord[0]);
                    processor.setSocketDesignation(tmpRecord[1]);
                    processor.setDescription(tmpRecord[2]);
                    processor.setCurrentClockSpeed(Long.parseLong(tmpRecord[3]));
                    processor.setreportId(report);
                    processorRepository.save(processor);
                    continue;
                }

                if (nextRecord[0].equals("Материнская плата")) {
                    // Обработка информации для Материнской платы
                    String[] tmpRecord = csvReader.readNext();
                    tmpRecord = csvReader.readNext();
                    Motherboard motherboard = new Motherboard();
                    motherboard.setManufacturer(tmpRecord[0]);
                    motherboard.setProduct(tmpRecord[1]);
                    motherboard.setSerialNumber(tmpRecord[2]);
                    motherboard.setStatus(tmpRecord[3]);
                    motherboard.setreportId(report);
                    motherboardRepository.save(motherboard);
                    continue;
                }

                if (nextRecord[0].equals("Жесткие диски")) {
                    // Обработка информации для Жестких дисков
                    String[] tmpRecord = csvReader.readNext();
                    tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "Логические диски")){
                        HDD hdd = new HDD();
                        hdd.setModel(tmpRecord[0]);
                        hdd.setPartitions(Long.parseLong(tmpRecord[1]));
                        hdd.setSize(Long.parseLong(tmpRecord[2]));
                        hdd.setInterfaceType(tmpRecord[3]);
                        hdd.setreportId(report);
                        hddRepository.save(hdd);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;
                }

                if (nextRecord[0].equals("DeviceID")) {
                    // Обработка информации для Логических дисков
                    String[] tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "Оперативная память")){
                        LogicalDrive logicalDrive = new LogicalDrive();
                        logicalDrive.setDeviceID(tmpRecord[0]);
                        logicalDrive.setFileSystem(tmpRecord[1]);
                        logicalDrive.setSize(Long.parseLong(tmpRecord[2]));
                        logicalDrive.setFreeSpace(Long.parseLong(tmpRecord[3]));
                        logicalDrive.setreportId(report);
                        logicalDriveRepository.save(logicalDrive);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;
                }

                if (nextRecord[0].equals("capacity")) {
                    // Обработка информации для Оперативной памяти
                    String[] tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "MemoryDevices")){
                        RAM ram = new RAM();
                        ram.setCapacity(Long.parseLong(tmpRecord[0]));
                        ram.setDeviceLocator(tmpRecord[1]);
                        ram.setManufacturer(tmpRecord[2]);
                        ram.setPartNumber(tmpRecord[3]);
                        ram.setSerialNumber(tmpRecord[4]);
                        ram.setTag(tmpRecord[5]);
                        ram.setTypeDetail(tmpRecord[6]);
                        ram.setMemoryType(Long.parseLong(tmpRecord[7]));
                        ram.setreportId(report);
                        ramRepository.save(ram);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;

                }

                if (nextRecord[0].equals("MemoryDevices")) {
                    // Обработка информации для MemoryDevices
                    String[] tmpRecord = csvReader.readNext();
                    RAMInfo ramInfo = new RAMInfo();
                    ramInfo.setMemoryDevices(Long.parseLong(tmpRecord[0]));
                    ramInfo.setreportId(report);
                    ramInfoRepository.save(ramInfo);
                    continue;
                }

                if (nextRecord[0].equals("Видеокарта")) {
                    // Обработка информации для Видеокарт
                    String[] tmpRecord = csvReader.readNext();
                    tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "Сетевая карта")){
                        GPU gpu = new GPU();
                        gpu.setName(tmpRecord[0]);
                        gpu.setVideoProcessor(tmpRecord[1]);
                        gpu.setreportId(report);
                        gpuRepository.save(gpu);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;
                }

                if (nextRecord[0].equals("Сетевая карта")) {
                    // Обработка информации для сетевых карт
                    String[] tmpRecord = csvReader.readNext();
                    tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "Сетевая информация")){
                        LANCard lanCard = new LANCard();
                        lanCard.setName(tmpRecord[0]);
                        lanCard.setAdapterType(tmpRecord[1]);
                        lanCard.setMacAddress(tmpRecord[2]);
                        lanCard.setreportId(report);
                        lanCardRepository.save(lanCard);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;
                }

                if (nextRecord[0].equals("PrefixOrigin")) {
                    // Обработка информации для Сетевой информации
                    String[] tmpRecord = csvReader.readNext();
                    while (!Objects.equals(tmpRecord[0], "Список установленного ПО")){
                        NetInfo netInfo = new NetInfo();
                        netInfo.setPrefixOrigin(tmpRecord[0]);
                        netInfo.setSuffixOrigin(tmpRecord[1]);
                        netInfo.setType(tmpRecord[2]);
                        netInfo.setStore(tmpRecord[3]);
                        netInfo.setAddressFamily(tmpRecord[4]);
                        netInfo.setAddressState(tmpRecord[5]);
                        netInfo.setProtocolIFType(tmpRecord[6]);
                        netInfo.setiPv4Address(tmpRecord[7]);
                        netInfo.setiPv6Address(tmpRecord[8]);
                        netInfo.setInterfaceAlias(tmpRecord[9]);
                        netInfo.setInterfaceIndex(tmpRecord[10]);
                        netInfo.setiPAddress(tmpRecord[11]);
                        netInfo.setreportId(report);
                        netInfoRepository.save(netInfo);
                        tmpRecord = csvReader.readNext();
                    }
                    continue;
                }
                if (nextRecord[0].equals("DisplayName")) {
                    // Обработка информации для Установленного ПО
                    String[] tmpRecord = csvReader.readNext();
                    Programs programs = new Programs();
                    programs.setDisplayName(tmpRecord[0]);
                    programs.setDisplayVersion(tmpRecord[1]);
                    programs.setPublisher(tmpRecord[2]);
                    programs.setInstallDate(tmpRecord[3]);
                    programs.setreportId(report);
                    programsRepository.save(programs);
                    while ((tmpRecord = csvReader.readNext()) != null){
                        Programs programs1 = new Programs();
                        programs1.setDisplayName(tmpRecord[0]);
                        programs1.setDisplayVersion(tmpRecord[1]);
                        programs1.setPublisher(tmpRecord[2]);
                        programs1.setInstallDate(tmpRecord[3]);
                        programs1.setreportId(report);
                        programsRepository.save(programs1);
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}