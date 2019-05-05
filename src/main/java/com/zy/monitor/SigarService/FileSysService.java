package com.zy.monitor.SigarService;

import com.zy.monitor.model.FileSys;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.List;

public class FileSysService {

    public static List<FileSys> getFilesys(Sigar sigar) throws SigarException {
        List<FileSys> fileSysList=new ArrayList<>();
        FileSystem fileSystem[]=sigar.getFileSystemList();
        for (FileSystem file: fileSystem) {
            if(file.getType()==2){
            FileSystemUsage usage=sigar.getFileSystemUsage(file.getDevName());
            FileSys fileSys=new FileSys(file.getDevName(),usage);
            fileSysList.add(fileSys);}
        }


        return fileSysList;

    }
}
