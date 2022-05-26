package Recursion;

import lombok.Data;

import java.io.File;
import java.util.Objects;

@Data
public class DiskUsage {

    public static long diskUsage(File root){
        long usage = root.length();
        if(root.isDirectory()){
            for(String childName : Objects.requireNonNull(root.list())){
                File child = new File(root, childName);
                usage += diskUsage(child);
            }
        }
        return usage;
    }
}
