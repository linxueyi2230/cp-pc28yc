package com.dandanyc.controller;

import com.dandanyc.entity.KenoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dandanyc.util.KenoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by prothezou on 2016/12/24.
 */
@Controller
@RequestMapping("/Keno")
public class KenoControl {

    private static final Log log = LogFactory.getLog(KenoControl.class);
    private static List<KenoDTO> kenoInfo = null;

    /**
     * PC蛋蛋开奖数据
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoInfo.html")
    public String getKenoInfo(ModelMap modelMap) {
        try {
            List<KenoDTO> kenoDTOList = KenoUtil.getKenoInfo();
            if (kenoDTOList != null && kenoDTOList.size() > 0) {
                modelMap.addAttribute("Keno", kenoDTOList);
                return "Keno/KenoInfo";
            } else {
                return "Keno/KenoInfo";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Keno/KenoInfo";
    }

    /**
     * PC蛋蛋走势图
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoTrend.html")
    public String getKenoTrend(ModelMap modelMap) {
        try {
            List<KenoDTO> kenoDTOList = KenoUtil.getKenoInfo();
            if (kenoDTOList != null && kenoDTOList.size() > 0) {
                modelMap.addAttribute("KenoTrend", kenoDTOList);
                log.info("当前数据："+kenoDTOList.size());
                return "Keno/KenoTrend";
            } else {
                return "Keno/KenoTrend";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Keno/KenoTrend";
    }

    /**
     * PC蛋蛋预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoYuce.html")
    public String getKenoYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();

            if (null == kenoInfo) {
                if (kenoYc != null && kenoYc.size() > 0) {
                    KenoDTO kenoDTO = new KenoDTO();
                    kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                    kenoDTO.setDate("...");
                    kenoDTO.setResult("...");
                    kenoDTO.setNumber("...");
                    kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTO);
                    for (KenoDTO keno : kenoYc
                            ) {
                        KenoDTO kenoDTOs = new KenoDTO();
                        kenoDTOs.setId(keno.getId());
                        kenoDTOs.setDate(keno.getDate());
                        kenoDTOs.setResult(keno.getResult());
                        kenoDTOs.setNumber(keno.getNumber());
                        kenoDTOs.setYuce(keno.getYuce());
                        kenoDTOList.add(kenoDTOs);
                    }
                    kenoInfo = kenoDTOList;
                    modelMap.addAttribute("KenoYuce", kenoDTOList);
                    return "Keno/KenoYuce";
                }
                return "Keno/KenoYuce";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!kenoYc.get(0).getId().equals(kenoInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    kenoInfo.remove(30);
                    // 然后新一轮预测
                    KenoDTO kenoDTO0 = new KenoDTO();
                    kenoDTO0.setId(String.valueOf(Integer.valueOf(kenoYc.get
                            (0).getId()) + 1));
                    kenoDTO0.setDate("...");
                    kenoDTO0.setNumber("...");
                    kenoDTO0.setResult("...");
                    kenoDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    kenoInfo.add(0, kenoDTO0);
                    // 将首次的一轮以此类推下面
                    KenoDTO kenoDTO1 = new KenoDTO();
                    kenoDTO1.setId(kenoInfo.get(1).getId());
                    kenoDTO1.setDate(kenoYc.get(0).getDate());
                    kenoDTO1.setNumber(kenoYc.get(0).getNumber());
                    kenoDTO1.setResult(kenoYc.get(0).getResult());
                    kenoDTO1.setYuce(kenoInfo.get(1).getYuce());
                    kenoInfo.set(1, kenoDTO1);

                }
                modelMap.addAttribute("KenoYuce", kenoInfo);
                return "Keno/KenoYuce";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Keno/KenoYuce";
    }

    /**
     * PC蛋蛋预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoYuceChange.html")
    public String getKenoYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();
            if (kenoYc != null && kenoYc.size() > 0) {
                KenoDTO kenoDTO = new KenoDTO();
                kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                kenoDTO.setDate("...");
                kenoDTO.setResult("...");
                kenoDTO.setNumber("...");
                kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                kenoDTOList.add(kenoDTO);
                for (KenoDTO keno : kenoYc
                        ) {
                    KenoDTO kenoDTOs = new KenoDTO();
                    kenoDTOs.setId(keno.getId());
                    kenoDTOs.setDate(keno.getDate());
                    kenoDTOs.setResult(keno.getResult());
                    kenoDTOs.setNumber(keno.getNumber());
                    kenoDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTOs);
                }
                kenoInfo = kenoDTOList;
                modelMap.addAttribute("KenoYuce", kenoDTOList);
                return "Keno/KenoYuce";
            }
            return "Keno/KenoYuce";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Keno/KenoYuce";
    }

    /**
     * PC蛋蛋单双预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoDsYuce.html")
    public String getKenoDsYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();

            if (null == kenoInfo) {
                if (kenoYc != null && kenoYc.size() > 0) {
                    KenoDTO kenoDTO = new KenoDTO();
                    kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                    kenoDTO.setDate("...");
                    kenoDTO.setResult("...");
                    kenoDTO.setNumber("...");
                    kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTO);
                    for (KenoDTO keno : kenoYc
                            ) {
                        KenoDTO kenoDTOs = new KenoDTO();
                        kenoDTOs.setId(keno.getId());
                        kenoDTOs.setDate(keno.getDate());
                        kenoDTOs.setResult(keno.getResult());
                        kenoDTOs.setNumber(keno.getNumber());
                        kenoDTOs.setYuce(keno.getYuce());
                        kenoDTOList.add(kenoDTOs);
                    }
                    kenoInfo = kenoDTOList;
                    modelMap.addAttribute("KenoYuce", kenoDTOList);
                    return "Keno/KenoDsYc";
                }
                return "Keno/KenoDsYc";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!kenoYc.get(0).getId().equals(kenoInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    kenoInfo.remove(30);
                    // 然后新一轮预测
                    KenoDTO kenoDTO0 = new KenoDTO();
                    kenoDTO0.setId(String.valueOf(Integer.valueOf(kenoYc.get
                            (0).getId()) + 1));
                    kenoDTO0.setDate("...");
                    kenoDTO0.setNumber("...");
                    kenoDTO0.setResult("...");
                    kenoDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    kenoInfo.add(0, kenoDTO0);
                    // 将首次的一轮以此类推下面
                    KenoDTO kenoDTO1 = new KenoDTO();
                    kenoDTO1.setId(kenoInfo.get(1).getId());
                    kenoDTO1.setDate(kenoYc.get(0).getDate());
                    kenoDTO1.setNumber(kenoYc.get(0).getNumber());
                    kenoDTO1.setResult(kenoYc.get(0).getResult());
                    kenoDTO1.setYuce(kenoInfo.get(1).getYuce());
                    kenoInfo.set(1, kenoDTO1);

                }
                modelMap.addAttribute("KenoYuce", kenoInfo);
                return "Keno/KenoDsYc";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Keno/KenoDsYc";
    }

    /**
     * PC蛋蛋单双预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoDsYuceChange.html")
    public String getKenoDsYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();
            if (kenoYc != null && kenoYc.size() > 0) {
                KenoDTO kenoDTO = new KenoDTO();
                kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                kenoDTO.setDate("...");
                kenoDTO.setResult("...");
                kenoDTO.setNumber("...");
                kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                kenoDTOList.add(kenoDTO);
                for (KenoDTO keno : kenoYc
                        ) {
                    KenoDTO kenoDTOs = new KenoDTO();
                    kenoDTOs.setId(keno.getId());
                    kenoDTOs.setDate(keno.getDate());
                    kenoDTOs.setResult(keno.getResult());
                    kenoDTOs.setNumber(keno.getNumber());
                    kenoDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTOs);
                }
                kenoInfo = kenoDTOList;
                modelMap.addAttribute("KenoYuce", kenoDTOList);
                return "Keno/KenoDsYc";
            }
            return "Keno/KenoDsYc";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Keno/KenoDsYc";
    }

    /**
     * PC蛋蛋大小预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoDxYuce.html")
    public String getKenoDxYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();

            if (null == kenoInfo) {
                if (kenoYc != null && kenoYc.size() > 0) {
                    KenoDTO kenoDTO = new KenoDTO();
                    kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                    kenoDTO.setDate("...");
                    kenoDTO.setResult("...");
                    kenoDTO.setNumber("...");
                    kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTO);
                    for (KenoDTO keno : kenoYc
                            ) {
                        KenoDTO kenoDTOs = new KenoDTO();
                        kenoDTOs.setId(keno.getId());
                        kenoDTOs.setDate(keno.getDate());
                        kenoDTOs.setResult(keno.getResult());
                        kenoDTOs.setNumber(keno.getNumber());
                        kenoDTOs.setYuce(keno.getYuce());
                        kenoDTOList.add(kenoDTOs);
                    }
                    kenoInfo = kenoDTOList;
                    modelMap.addAttribute("KenoYuce", kenoDTOList);
                    return "Keno/KenoDxYc";
                }
                return "Keno/KenoDxYc";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!kenoYc.get(0).getId().equals(kenoInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    kenoInfo.remove(30);
                    // 然后新一轮预测
                    KenoDTO kenoDTO0 = new KenoDTO();
                    kenoDTO0.setId(String.valueOf(Integer.valueOf(kenoYc.get
                            (0).getId()) + 1));
                    kenoDTO0.setDate("...");
                    kenoDTO0.setNumber("...");
                    kenoDTO0.setResult("...");
                    kenoDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    kenoInfo.add(0, kenoDTO0);
                    // 将首次的一轮以此类推下面
                    KenoDTO kenoDTO1 = new KenoDTO();
                    kenoDTO1.setId(kenoInfo.get(1).getId());
                    kenoDTO1.setDate(kenoYc.get(0).getDate());
                    kenoDTO1.setNumber(kenoYc.get(0).getNumber());
                    kenoDTO1.setResult(kenoYc.get(0).getResult());
                    kenoDTO1.setYuce(kenoInfo.get(1).getYuce());
                    kenoInfo.set(1, kenoDTO1);

                }
                modelMap.addAttribute("KenoYuce", kenoInfo);
                return "Keno/KenoDxYc";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Keno/KenoDxYc";
    }

    /**
     * PC蛋蛋大小预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/KenoDxYuceChange.html")
    public String getKenoDxYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<KenoDTO> kenoYc = KenoUtil.getKenoInfo();
            if (kenoYc != null && kenoYc.size() > 0) {
                KenoDTO kenoDTO = new KenoDTO();
                kenoDTO.setId(String.valueOf(Integer.valueOf(kenoYc.get(0).getId()) + 1));
                kenoDTO.setDate("...");
                kenoDTO.setResult("...");
                kenoDTO.setNumber("...");
                kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
                kenoDTOList.add(kenoDTO);
                for (KenoDTO keno : kenoYc
                        ) {
                    KenoDTO kenoDTOs = new KenoDTO();
                    kenoDTOs.setId(keno.getId());
                    kenoDTOs.setDate(keno.getDate());
                    kenoDTOs.setResult(keno.getResult());
                    kenoDTOs.setNumber(keno.getNumber());
                    kenoDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    kenoDTOList.add(kenoDTOs);
                }
                kenoInfo = kenoDTOList;
                modelMap.addAttribute("KenoYuce", kenoDTOList);
                return "Keno/KenoDxYc";
            }
            return "Keno/KenoDxYc";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Keno/KenoDxYc";
    }

}
