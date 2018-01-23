package com.dandanyc.test;

import com.dandanyc.entity.KenoDTO;
import com.dandanyc.util.KenoUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prothezou on 2017/3/29.
 */
public class DangeSfTest {

    public static void main(String[] args) {
        List<int[]> listArray = new ArrayList<int[]>();
        List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();
        if (null!=kenoYc&&kenoYc.size()>0) {
            for (KenoDTO ky : kenoYc
                    ) {
                String[] data = ky.getNumber().split("\\+");
                int[] dataArray = {Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])};
                listArray.add(dataArray);
            }
        }

    }
}
