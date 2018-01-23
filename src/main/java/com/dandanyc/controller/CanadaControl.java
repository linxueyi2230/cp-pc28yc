package com.dandanyc.controller;

import com.dandanyc.entity.CanadaDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dandanyc.util.CanadaUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by prothezou on 2016/12/24.
 */
@Controller
@RequestMapping("/Canada")
public class CanadaControl {

    private static final Log log = LogFactory.getLog(CanadaControl.class);
    private static List<CanadaDTO> canadaInfo = null;
    private HttpSession session;

    /**
     * 加拿大开奖数据
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaInfo.html")
    public String getCanadaInfo(HttpServletRequest request, ModelMap modelMap) {
        try {
            List<CanadaDTO> canadaDTOList = CanadaUtil.getCanadaInfo();
            if (canadaDTOList != null && canadaDTOList.size() > 0) {
                modelMap.addAttribute("CanadaInfo", canadaDTOList);
                return "Canada/CanadaInfo";
            } else {
                return "Canada/CanadaInfo";
            }
        } catch (Exception ex) {
            log.error("加拿大前台展示数据异常：" + ex);
        }
        return "Canada/CanadaInfo";
    }

    /**
     * 加拿大走势分析
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaTrend.html")
    public String getCanadaThrends(ModelMap modelMap) {
        try {
            List<CanadaDTO> canadaDTOList = CanadaUtil.getCanadaInfo();
            if (canadaDTOList != null && canadaDTOList.size() > 0) {
                modelMap.addAttribute("CanadaTrend", canadaDTOList);
                return "Canada/CanadaTrend";
            } else {
                return "Canada/CanadaTrend";
            }
        } catch (Exception ex) {
            log.error("加拿大前台展示数据异常：" + ex);
        }
        return "Canada/CanadaTrend";
    }

    /**
     * 加拿大预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaYuce.html")
    public String getCanadaYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();

            if (null == canadaInfo) {
                if (canadaYc != null && canadaYc.size() > 0) {
                    CanadaDTO canadaDTO = new CanadaDTO();
                    canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId()) + 1));
                    canadaDTO.setDate("...");
                    canadaDTO.setResult("...");
                    canadaDTO.setNumber("...");
                    canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTO);
                    for (CanadaDTO canada : canadaYc
                            ) {
                        CanadaDTO canadaDTOs = new CanadaDTO();
                        canadaDTOs.setId(canada.getId());
                        canadaDTOs.setDate(canada.getDate());
                        canadaDTOs.setResult(canada.getResult());
                        canadaDTOs.setNumber(canada.getNumber());
                        canadaDTOs.setYuce(canada.getYuce());
                        canadaDTOList.add(canadaDTOs);
                    }
                    canadaInfo = canadaDTOList;
                    modelMap.addAttribute("CanadaYuce", canadaDTOList);
                    return "Canada/CanadaYuce";
                }
                return "Canada/CanadaYuce";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!canadaYc.get(0).getId().equals(canadaInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    canadaInfo.remove(30);
                    // 然后新一轮预测
                    CanadaDTO canadaDTO0 = new CanadaDTO();
                    canadaDTO0.setId(String.valueOf(Integer.valueOf(canadaInfo.get
                            (0).getId()) + 1));
                    canadaDTO0.setDate("...");
                    canadaDTO0.setNumber("...");
                    canadaDTO0.setResult("...");
                    canadaDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    canadaInfo.add(0, canadaDTO0);
                    // 将首次的一轮以此类推下面
                    CanadaDTO canadaDTO1 = new CanadaDTO();
                    canadaDTO1.setId(canadaInfo.get(1).getId());
                    canadaDTO1.setDate(canadaYc.get(0).getDate());
                    canadaDTO1.setNumber(canadaYc.get(0).getNumber());
                    canadaDTO1.setResult(canadaYc.get(0).getResult());
                    canadaDTO1.setYuce(canadaInfo.get(1).getYuce());
                    canadaInfo.set(1, canadaDTO1);

                }
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaYuce";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Canada/CanadaYuce";
    }

    /**
     * 加拿大预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaYuceChange.html")
    public String getCanadaYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();
            if (canadaYc != null && canadaYc.size() > 0) {
                CanadaDTO canadaDTO = new CanadaDTO();
                canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId
                        ()) + 1));
                canadaDTO.setDate("...");
                canadaDTO.setResult("...");
                canadaDTO.setNumber("...");
                canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                canadaDTOList.add(canadaDTO);
                for (CanadaDTO canada : canadaYc
                        ) {
                    CanadaDTO canadaDTOs = new CanadaDTO();
                    canadaDTOs.setId(canada.getId());
                    canadaDTOs.setDate(canada.getDate());
                    canadaDTOs.setResult(canada.getResult());
                    canadaDTOs.setNumber(canada.getNumber());
                    canadaDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTOs);
                }
                canadaInfo = canadaDTOList;
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaYuce";
            }
            return "Canada/CanadaYuce";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Canada/CanadaYuce";
    }


    /**
     * 加拿大单双预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaDsYuce.html")
    public String getCanadaDsYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();

            if (null == canadaInfo) {
                if (canadaYc != null && canadaYc.size() > 0) {
                    CanadaDTO canadaDTO = new CanadaDTO();
                    canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId()) + 1));
                    canadaDTO.setDate("...");
                    canadaDTO.setResult("...");
                    canadaDTO.setNumber("...");
                    canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTO);
                    for (CanadaDTO canada : canadaYc
                            ) {
                        CanadaDTO canadaDTOs = new CanadaDTO();
                        canadaDTOs.setId(canada.getId());
                        canadaDTOs.setDate(canada.getDate());
                        canadaDTOs.setResult(canada.getResult());
                        canadaDTOs.setNumber(canada.getNumber());
                        canadaDTOs.setYuce(canada.getYuce());
                        canadaDTOList.add(canadaDTOs);
                    }
                    canadaInfo = canadaDTOList;
                    modelMap.addAttribute("CanadaYuce", canadaDTOList);
                    return "Canada/CanadaDsYc";
                }
                return "Canada/CanadaDsYc";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!canadaYc.get(0).getId().equals(canadaInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    canadaInfo.remove(30);
                    // 然后新一轮预测
                    CanadaDTO canadaDTO0 = new CanadaDTO();
                    canadaDTO0.setId(String.valueOf(Integer.valueOf(canadaInfo.get
                            (0).getId()) + 1));
                    canadaDTO0.setDate("...");
                    canadaDTO0.setNumber("...");
                    canadaDTO0.setResult("...");
                    canadaDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    canadaInfo.add(0, canadaDTO0);
                    // 将首次的一轮以此类推下面
                    CanadaDTO canadaDTO1 = new CanadaDTO();
                    canadaDTO1.setId(canadaInfo.get(1).getId());
                    canadaDTO1.setDate(canadaYc.get(0).getDate());
                    canadaDTO1.setNumber(canadaYc.get(0).getNumber());
                    canadaDTO1.setResult(canadaYc.get(0).getResult());
                    canadaDTO1.setYuce(canadaInfo.get(1).getYuce());
                    canadaInfo.set(1, canadaDTO1);

                }
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaDsYc";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Canada/CanadaDsYc";
    }


    /**
     * 加拿大单双预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaDsYuceChange.html")
    public String getCanadaDsYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();
            if (canadaYc != null && canadaYc.size() > 0) {
                CanadaDTO canadaDTO = new CanadaDTO();
                canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId
                        ()) + 1));
                canadaDTO.setDate("...");
                canadaDTO.setResult("...");
                canadaDTO.setNumber("...");
                canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                canadaDTOList.add(canadaDTO);
                for (CanadaDTO canada : canadaYc
                        ) {
                    CanadaDTO canadaDTOs = new CanadaDTO();
                    canadaDTOs.setId(canada.getId());
                    canadaDTOs.setDate(canada.getDate());
                    canadaDTOs.setResult(canada.getResult());
                    canadaDTOs.setNumber(canada.getNumber());
                    canadaDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTOs);
                }
                canadaInfo = canadaDTOList;
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaDsYc";
            }
            return "Canada/CanadaDsYc";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Canada/CanadaDsYc";
    }


    /**
     * 加拿大大小预测
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaDxYuce.html")
    public String getCanadaDxYuce(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();

            if (null == canadaInfo) {
                if (canadaYc != null && canadaYc.size() > 0) {
                    CanadaDTO canadaDTO = new CanadaDTO();
                    canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId()) + 1));
                    canadaDTO.setDate("...");
                    canadaDTO.setResult("...");
                    canadaDTO.setNumber("...");
                    canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTO);
                    for (CanadaDTO canada : canadaYc
                            ) {
                        CanadaDTO canadaDTOs = new CanadaDTO();
                        canadaDTOs.setId(canada.getId());
                        canadaDTOs.setDate(canada.getDate());
                        canadaDTOs.setResult(canada.getResult());
                        canadaDTOs.setNumber(canada.getNumber());
                        canadaDTOs.setYuce(canada.getYuce());
                        canadaDTOList.add(canadaDTOs);
                    }
                    canadaInfo = canadaDTOList;
                    modelMap.addAttribute("CanadaYuce", canadaDTOList);
                    return "Canada/CanadaDxYc";
                }
                return "Canada/CanadaDxYc";
            } else {
                // 如果期号还是当前期号就代表还没有开奖
                if (!canadaYc.get(0).getId().equals(canadaInfo.get(1).getId())) {
                    // 首先移除末尾数据第三十行
                    canadaInfo.remove(30);
                    // 然后新一轮预测
                    CanadaDTO canadaDTO0 = new CanadaDTO();
                    canadaDTO0.setId(String.valueOf(Integer.valueOf(canadaInfo.get
                            (0).getId()) + 1));
                    canadaDTO0.setDate("...");
                    canadaDTO0.setNumber("...");
                    canadaDTO0.setResult("...");
                    canadaDTO0.setYuce(String.valueOf(random.nextInt(27)));
                    canadaInfo.add(0, canadaDTO0);
                    // 将首次的一轮以此类推下面
                    CanadaDTO canadaDTO1 = new CanadaDTO();
                    canadaDTO1.setId(canadaInfo.get(1).getId());
                    canadaDTO1.setDate(canadaYc.get(0).getDate());
                    canadaDTO1.setNumber(canadaYc.get(0).getNumber());
                    canadaDTO1.setResult(canadaYc.get(0).getResult());
                    canadaDTO1.setYuce(canadaInfo.get(1).getYuce());
                    canadaInfo.set(1, canadaDTO1);

                }
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaDxYc";
            }
        } catch (Exception ex) {
            log.error("PC蛋蛋前台展示数据异常：" + ex);
        }
        return "Canada/CanadaDxYc";
    }


    /**
     * 加拿大大小预测算法更换
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/CanadaDxYuceChange.html")
    public String getCanadaDxYuceChange(ModelMap modelMap) {
        try {
            Random random = new Random();
            List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
            // 获取最新PC蛋蛋开奖数据
            List<CanadaDTO> canadaYc = CanadaUtil.getCanadaInfo();
            if (canadaYc != null && canadaYc.size() > 0) {
                CanadaDTO canadaDTO = new CanadaDTO();
                canadaDTO.setId(String.valueOf(Integer.valueOf(canadaYc.get(0).getId
                        ()) + 1));
                canadaDTO.setDate("...");
                canadaDTO.setResult("...");
                canadaDTO.setNumber("...");
                canadaDTO.setYuce(String.valueOf(random.nextInt(27)));
                canadaDTOList.add(canadaDTO);
                for (CanadaDTO canada : canadaYc
                        ) {
                    CanadaDTO canadaDTOs = new CanadaDTO();
                    canadaDTOs.setId(canada.getId());
                    canadaDTOs.setDate(canada.getDate());
                    canadaDTOs.setResult(canada.getResult());
                    canadaDTOs.setNumber(canada.getNumber());
                    canadaDTOs.setYuce(String.valueOf(random.nextInt(27)));
                    canadaDTOList.add(canadaDTOs);
                }
                canadaInfo = canadaDTOList;
                modelMap.addAttribute("CanadaYuce", canadaInfo);
                return "Canada/CanadaDxYc";
            }
            return "Canada/CanadaDxYc";
        } catch (Exception ex) {
            log.error("PC蛋蛋预测更换算法异常：" + ex);
        }
        return "Canada/CanadaDxYc";
    }

}
