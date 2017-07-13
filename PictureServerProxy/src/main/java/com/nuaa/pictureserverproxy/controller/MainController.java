package com.nuaa.pictureserverproxy.controller;

/**
 * Created by free on 16-11-16.
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@Controller

public class MainController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping("/fetchpic")
    public ModelAndView fetchpic(@RequestParam Integer chartid, HttpServletResponse response) {
        String chartoption = "undefined";
        //Option option = new Option();
        //
        switch (chartid)
        {
            case 1:
            {
                //-----------------------PIE Chart---------------------------------
                String piedata = "[{value:5, name:\"未开工：5\"},{value:4, name:\"待审查:4\"},{value:1, name:\"墨水更改中:1\"},{value:39, name:\"工序完成中:39\"},{value:57, name:\"已归档:57\"}]";
                chartoption = "{\n" +
                        " \"title\": {\n" +
                        "  \"show\": true,\n" +
                        "  \"text\": \"AO执行情况\",\n" +
                        "  \"left\": \"center\"\n" +
                        " },\n" +
                        " \"tooltip\": {\n" +
                        "  \"trigger\": \"item\",\n" +
                        "  \"formatter\": \"{a} <br/>{b}: {c} ({d}%)\"\n" +
                        " },\n" +
                        " \"toolbox\": {\n" +
                        "  \"show\": true,\n" +
                        "  \"feature\": {\n" +
                        "   \"saveAsImage\": {\n" +
                        "    \"backgroundColor\": \"rgba(255,255,255,0.0)\"\n" +
                        "   }\n" +
                        "  }\n" +
                        " },\n" +
                        " \"legend\": {\n" +
                        "  \"orient\": \"vertical\",\n" +
                        "  \"x\": \"right\",\n" +
                        "  \"y\": \"center\",\n" +
                        "  \"data\": [\n" +
                        "   \"未开工：5\",\n" +
                        "   \"待审查:4\",\n" +
                        "   \"墨水更改中:1\",\n" +
                        "   \"工序完成中:39\",\n" +
                        "   \"已归档:57\"\n" +
                        "  ]\n" +
                        " },\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"访问来源\",\n" +
                        "   \"type\": \"pie\",\n" +
                        "   \"radius\": [\n" +
                        "    \"30%\",\n" +
                        "    \"70%\"\n" +
                        "   ],\n" +
                        "   \"avoidLabelOverlap\": false,\n" +
                        "   \"label\": {\n" +
                        "    \"normal\": {\n" +
                        "     \"show\": false,\n" +
                        "     \"position\": \"center\"\n" +
                        "    },\n" +
                        "    \"emphasis\": {\n" +
                        "     \"show\": true,\n" +
                        "     \"textStyle\": {\n" +
                        "      \"fontSize\": \"30\",\n" +
                        "      \"fontWeight\": \"bold\"\n" +
                        "     }\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"labelLine\": {\n" +
                        "    \"normal\": {\n" +
                        "     \"show\": false\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"data\": " +
                        piedata +
                        "  }\n" +
                        " ]\n" +
                        "}";

                break;
            }

            //--------------------Bar 柱状图-----------------------
            case 2:
            {
                String bardata="[10, 52, 200, 334, 390, 330, 220]";
                chartoption="{\n" +
                        " \"color\": [\n" +
                        "  \"#3398DB\"\n" +
                        " ],\n" +
                        " \"tooltip\": {\n" +
                        "  \"trigger\": \"axis\",\n" +
                        "  \"axisPointer\": {\n" +
                        "   \"type\": \"shadow\"\n" +
                        "  }\n" +
                        " },\n" +
                        " \"grid\": {\n" +
                        "  \"left\": \"3%\",\n" +
                        "  \"right\": \"4%\",\n" +
                        "  \"bottom\": \"3%\",\n" +
                        "  \"containLabel\": true\n" +
                        " },\n" +
                        " \"xAxis\": [\n" +
                        "  {\n" +
                        "   \"type\": \"category\",\n" +
                        "   \"data\": [\n" +
                        "    \"Mon\",\n" +
                        "    \"Tue\",\n" +
                        "    \"Wed\",\n" +
                        "    \"Thu\",\n" +
                        "    \"Fri\",\n" +
                        "    \"Sat\",\n" +
                        "    \"Sun\"\n" +
                        "   ],\n" +
                        "   \"axisTick\": {\n" +
                        "    \"alignWithLabel\": true\n" +
                        "   }\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"yAxis\": [\n" +
                        "  {\n" +
                        "   \"type\": \"value\"\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"直接访问\",\n" +
                        "   \"type\": \"bar\",\n" +
                        "   \"barWidth\": \"60%\",\n" +
                        "   \"data\":" +
                        bardata +
                        "  }\n" +
                        " ]\n" +
                        "}";

                break;
            }

            case 3:
            {
                String linedata1 ="[11, 11, 15, 13, 12, 13, 10]";
                String linedata2 = "[1, -2, 2, 5, 3, 2, 0]";
                chartoption="{\n" +
                        " \"title\": {\n" +
                        "  \"text\": \"未来一周气温变化\",\n" +
                        "  \"subtext\": \"纯属虚构\"\n" +
                        " },\n" +
                        " \"tooltip\": {\n" +
                        "  \"trigger\": \"axis\"\n" +
                        " },\n" +
                        " \"legend\": {\n" +
                        "  \"data\": [\n" +
                        "   \"最高气温\",\n" +
                        "   \"最低气温\"\n" +
                        "  ]\n" +
                        " },\n" +
                        " \"toolbox\": {\n" +
                        "  \"show\": true,\n" +
                        "  \"feature\": {\n" +
                        "   \"dataZoom\": {\n" +
                        "    \"yAxisIndex\": \"none\"\n" +
                        "   },\n" +
                        "   \"dataView\": {\n" +
                        "    \"readOnly\": false\n" +
                        "   },\n" +
                        "   \"magicType\": {\n" +
                        "    \"type\": [\n" +
                        "     \"line\",\n" +
                        "     \"bar\"\n" +
                        "    ]\n" +
                        "   },\n" +
                        "   \"restore\": {},\n" +
                        "   \"saveAsImage\": {}\n" +
                        "  }\n" +
                        " },\n" +
                        " \"xAxis\": {\n" +
                        "  \"type\": \"category\",\n" +
                        "  \"boundaryGap\": false,\n" +
                        "  \"data\": [\n" +
                        "   \"周一\",\n" +
                        "   \"周二\",\n" +
                        "   \"周三\",\n" +
                        "   \"周四\",\n" +
                        "   \"周五\",\n" +
                        "   \"周六\",\n" +
                        "   \"周日\"\n" +
                        "  ]\n" +
                        " },\n" +
                        " \"yAxis\": {\n" +
                        "  \"type\": \"value\",\n" +
                        "  \"axisLabel\": {\n" +
                        "   \"formatter\": \"{value} °C\"\n" +
                        "  }\n" +
                        " },\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"最高气温\",\n" +
                        "   \"type\": \"line\",\n" +
                        "   \"data\": " +
                        linedata1 +
                        ","+
                        "   \"markPoint\": {\n" +
                        "    \"data\": [\n" +
                        "     {\n" +
                        "      \"type\": \"max\",\n" +
                        "      \"name\": \"最大值\"\n" +
                        "     },\n" +
                        "     {\n" +
                        "      \"type\": \"min\",\n" +
                        "      \"name\": \"最小值\"\n" +
                        "     }\n" +
                        "    ]\n" +
                        "   },\n" +
                        "   \"markLine\": {\n" +
                        "    \"data\": [\n" +
                        "     {\n" +
                        "      \"type\": \"average\",\n" +
                        "      \"name\": \"平均值\"\n" +
                        "     }\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"name\": \"最低气温\",\n" +
                        "   \"type\": \"line\",\n" +
                        "   \"data\":" +
                        linedata2 +
                        ","+
                        "   \"markPoint\": {\n" +
                        "    \"data\": [\n" +
                        "     {\n" +
                        "      \"name\": \"周最低\",\n" +
                        "      \"value\": -2,\n" +
                        "      \"xAxis\": 1,\n" +
                        "      \"yAxis\": -1.5\n" +
                        "     }\n" +
                        "    ]\n" +
                        "   },\n" +
                        "   \"markLine\": {\n" +
                        "    \"data\": [\n" +
                        "     {\n" +
                        "      \"type\": \"average\",\n" +
                        "      \"name\": \"平均值\"\n" +
                        "     },\n" +
                        "     [\n" +
                        "      {\n" +
                        "       \"symbol\": \"none\",\n" +
                        "       \"x\": \"90%\",\n" +
                        "       \"yAxis\": \"max\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "       \"symbol\": \"circle\",\n" +
                        "       \"label\": {\n" +
                        "        \"normal\": {\n" +
                        "         \"position\": \"start\",\n" +
                        "         \"formatter\": \"最大值\"\n" +
                        "        }\n" +
                        "       },\n" +
                        "       \"type\": \"max\",\n" +
                        "       \"name\": \"最高点\"\n" +
                        "      }\n" +
                        "     ]\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  }\n" +
                        " ]\n" +
                        "}";

                break;
            }
            case 4:
            {
                String scatterdata1 = "[10.0,8.04],[8.0,6.95],[13.0,7.58],[9.0,8.81],[11.0,8.33],[14.0,9.96],[6.0,7.24],[4.0,4.26],[12.0,10.84],[7.0,4.82],[5.0,5.68]";
                String scatterdata2 = "[10.0,9.14],[8.0,8.14],[13.0,8.74],[9.0,8.77],[11.0,9.26],[14.0,8.10],[6.0,6.13],[4.0,3.10],[12.0,9.13],[7.0,7.26],[5.0,4.74]";
                String scatterdata3 = "[10.0,7.46],[8.0,6.77],[13.0,12.74],[9.0,7.11],[11.0,7.81],[14.0,8.84],[6.0,6.08],[4.0,5.39],[12.0,8.15],[7.0,6.42],[5.0,5.73]";
                String scatterdata4 = "[8.0,6.58],[8.0,5.76],[8.0,7.71],[8.0,8.84],[8.0,8.47],[8.0,7.04],[8.0,5.25],[19.0,12.50],[8.0,5.56],[8.0,7.91],[8.0,6.89]";
                chartoption = "{\n" +
                        " \"title\": {\n" +
                        "  \"text\": \"Anscombe's quartet\",\n" +
                        "  \"x\": \"center\",\n" +
                        "  \"y\": 0\n" +
                        " },\n" +
                        " \"grid\": [\n" +
                        "  {\n" +
                        "   \"x\": \"7%\",\n" +
                        "   \"y\": \"7%\",\n" +
                        "   \"width\": \"38%\",\n" +
                        "   \"height\": \"38%\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"x2\": \"7%\",\n" +
                        "   \"y\": \"7%\",\n" +
                        "   \"width\": \"38%\",\n" +
                        "   \"height\": \"38%\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"x\": \"7%\",\n" +
                        "   \"y2\": \"7%\",\n" +
                        "   \"width\": \"38%\",\n" +
                        "   \"height\": \"38%\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"x2\": \"7%\",\n" +
                        "   \"y2\": \"7%\",\n" +
                        "   \"width\": \"38%\",\n" +
                        "   \"height\": \"38%\"\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"tooltip\": {\n" +
                        "  \"formatter\": \"Group {a}: ({c})\"\n" +
                        " },\n" +
                        " \"xAxis\": [\n" +
                        "  {\n" +
                        "   \"gridIndex\": 0,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 20\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 1,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 20\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 2,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 20\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 3,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 20\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"yAxis\": [\n" +
                        "  {\n" +
                        "   \"gridIndex\": 0,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 15\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 1,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 15\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 2,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 15\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"gridIndex\": 3,\n" +
                        "   \"min\": 0,\n" +
                        "   \"max\": 15\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"I\",\n" +
                        "   \"type\": \"scatter\",\n" +
                        "   \"xAxisIndex\": 0,\n" +
                        "   \"yAxisIndex\": 0,\n" +
                        "   \"data\": [\n" +
                       scatterdata1 +
                        "   ],\n" +
                        "   \"markLine\": {\n" +
                        "    \"animation\": false,\n" +
                        "    \"label\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"formatter\": \"y = 0.5 * x + 3\",\n" +
                        "      \"textStyle\": {\n" +
                        "       \"align\": \"right\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"type\": \"solid\"\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"tooltip\": {\n" +
                        "     \"formatter\": \"y = 0.5 * x + 3\"\n" +
                        "    },\n" +
                        "    \"data\": [\n" +
                        "     [\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        0,\n" +
                        "        3\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        20,\n" +
                        "        13\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      }\n" +
                        "     ]\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"name\": \"II\",\n" +
                        "   \"type\": \"scatter\",\n" +
                        "   \"xAxisIndex\": 1,\n" +
                        "   \"yAxisIndex\": 1,\n" +
                        "   \"data\": [\n" +
                        scatterdata2 +
                        "   ],\n" +
                        "   \"markLine\": {\n" +
                        "    \"animation\": false,\n" +
                        "    \"label\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"formatter\": \"y = 0.5 * x + 3\",\n" +
                        "      \"textStyle\": {\n" +
                        "       \"align\": \"right\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"type\": \"solid\"\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"tooltip\": {\n" +
                        "     \"formatter\": \"y = 0.5 * x + 3\"\n" +
                        "    },\n" +
                        "    \"data\": [\n" +
                        "     [\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        0,\n" +
                        "        3\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        20,\n" +
                        "        13\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      }\n" +
                        "     ]\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"name\": \"III\",\n" +
                        "   \"type\": \"scatter\",\n" +
                        "   \"xAxisIndex\": 2,\n" +
                        "   \"yAxisIndex\": 2,\n" +
                        "   \"data\": [\n" +
                        scatterdata3 +
                        "   ],\n" +
                        "   \"markLine\": {\n" +
                        "    \"animation\": false,\n" +
                        "    \"label\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"formatter\": \"y = 0.5 * x + 3\",\n" +
                        "      \"textStyle\": {\n" +
                        "       \"align\": \"right\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"type\": \"solid\"\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"tooltip\": {\n" +
                        "     \"formatter\": \"y = 0.5 * x + 3\"\n" +
                        "    },\n" +
                        "    \"data\": [\n" +
                        "     [\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        0,\n" +
                        "        3\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        20,\n" +
                        "        13\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      }\n" +
                        "     ]\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"name\": \"IV\",\n" +
                        "   \"type\": \"scatter\",\n" +
                        "   \"xAxisIndex\": 3,\n" +
                        "   \"yAxisIndex\": 3,\n" +
                        "   \"data\": [\n" +
                        scatterdata4 +
                        "   ],\n" +
                        "   \"markLine\": {\n" +
                        "    \"animation\": false,\n" +
                        "    \"label\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"formatter\": \"y = 0.5 * x + 3\",\n" +
                        "      \"textStyle\": {\n" +
                        "       \"align\": \"right\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"normal\": {\n" +
                        "      \"type\": \"solid\"\n" +
                        "     }\n" +
                        "    },\n" +
                        "    \"tooltip\": {\n" +
                        "     \"formatter\": \"y = 0.5 * x + 3\"\n" +
                        "    },\n" +
                        "    \"data\": [\n" +
                        "     [\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        0,\n" +
                        "        3\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "       \"coord\": [\n" +
                        "        20,\n" +
                        "        13\n" +
                        "       ],\n" +
                        "       \"symbol\": \"none\"\n" +
                        "      }\n" +
                        "     ]\n" +
                        "    ]\n" +
                        "   }\n" +
                        "  }\n" +
                        " ]\n" +
                        "}";

                break;
            }
            case 5:
            {
                String value1 = "[100, 8, 0.40, -80, 2000]";
                String value2 = "[60, 5, 0.30, -100, 1500]";
                String value3 = "[120, 118, 130, 100, 99, 70]";
                String value4 = "[90, 113, 140, 30, 70, 60]";
                chartoption ="{\n" +
                        " \"title\": {\n" +
                        "  \"text\": \"自定义雷达图\"\n" +
                        " },\n" +
                        " \"legend\": {\n" +
                        "  \"data\": [\n" +
                        "   \"图一\",\n" +
                        "   \"图二\",\n" +
                        "   \"张三\",\n" +
                        "   \"李四\"\n" +
                        "  ]\n" +
                        " },\n" +
                        " \"radar\": [\n" +
                        "  {\n" +
                        "   \"indicator\": [\n" +
                        "    {\n" +
                        "     \"text\": \"指标一\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"指标二\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"指标三\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"指标四\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"指标五\"\n" +
                        "    }\n" +
                        "   ],\n" +
                        "   \"center\": [\n" +
                        "    \"25%\",\n" +
                        "    \"50%\"\n" +
                        "   ],\n" +
                        "   \"radius\": 120,\n" +
                        "   \"startAngle\": 90,\n" +
                        "   \"splitNumber\": 4,\n" +
                        "   \"shape\": \"circle\",\n" +
                        "   \"name\": {\n" +
                        "    \"formatter\": \"【{value}】\",\n" +
                        "    \"textStyle\": {\n" +
                        "     \"color\": \"#72ACD1\"\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"splitArea\": {\n" +
                        "    \"areaStyle\": {\n" +
                        "     \"color\": [\n" +
                        "      \"rgba(114, 172, 209, 0.2)\",\n" +
                        "      \"rgba(114, 172, 209, 0.4)\",\n" +
                        "      \"rgba(114, 172, 209, 0.6)\",\n" +
                        "      \"rgba(114, 172, 209, 0.8)\",\n" +
                        "      \"rgba(114, 172, 209, 1)\"\n" +
                        "     ],\n" +
                        "     \"shadowColor\": \"rgba(0, 0, 0, 0.3)\",\n" +
                        "     \"shadowBlur\": 10\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"axisLine\": {\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"color\": \"rgba(255, 255, 255, 0.5)\"\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"splitLine\": {\n" +
                        "    \"lineStyle\": {\n" +
                        "     \"color\": \"rgba(255, 255, 255, 0.5)\"\n" +
                        "    }\n" +
                        "   }\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"indicator\": [\n" +
                        "    {\n" +
                        "     \"text\": \"语文\",\n" +
                        "     \"max\": 150\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"数学\",\n" +
                        "     \"max\": 150\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"英语\",\n" +
                        "     \"max\": 150\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"物理\",\n" +
                        "     \"max\": 120\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"化学\",\n" +
                        "     \"max\": 108\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"text\": \"生物\",\n" +
                        "     \"max\": 72\n" +
                        "    }\n" +
                        "   ],\n" +
                        "   \"center\": [\n" +
                        "    \"75%\",\n" +
                        "    \"50%\"\n" +
                        "   ],\n" +
                        "   \"radius\": 120\n" +
                        "  }\n" +
                        " ],\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"雷达图\",\n" +
                        "   \"type\": \"radar\",\n" +
                        "   \"itemStyle\": {\n" +
                        "    \"emphasis\": {\n" +
                        "     \"lineStyle\": {\n" +
                        "      \"width\": 4\n" +
                        "     }\n" +
                        "    }\n" +
                        "   },\n" +
                        "   \"data\": [\n" +
                        "    {\n" +
                        "     \"value\": " +
                        value1+
                        ",\n" +
                        "     \"name\": \"图一\",\n" +
                        "     \"symbol\": \"rect\",\n" +
                        "     \"symbolSize\": 5,\n" +
                        "     \"lineStyle\": {\n" +
                        "      \"normal\": {\n" +
                        "       \"type\": \"dashed\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"value\": " +
                        value2 +
                        ",\n" +
                        "     \"name\": \"图二\",\n" +
                        "     \"areaStyle\": {\n" +
                        "      \"normal\": {\n" +
                        "       \"color\": \"rgba(255, 255, 255, 0.5)\"\n" +
                        "      }\n" +
                        "     }\n" +
                        "    }\n" +
                        "   ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"name\": \"成绩单\",\n" +
                        "   \"type\": \"radar\",\n" +
                        "   \"radarIndex\": 1,\n" +
                        "   \"data\": [\n" +
                        "    {\n" +
                        "     \"value\": " +
                        value3+
                        ",\n" +
                        "     \"name\": \"张三\",\n" +
                        "     \"label\": {\n" +
                        "      \"normal\": {\n" +
                        "       \"show\": true\n" +
                        "      }\n" +
                        "     }\n" +
                        "    },\n" +
                        "    {\n" +
                        "     \"value\": " +
                        value4+
                        ",\n" +
                        "     \"name\": \"李四\",\n" +
                        "     \"areaStyle\": {\n" +
                        "      \"normal\": {\n" +
                        "       \"opacity\": 0.9,\n" +
                        "       \"color\": {\n" +
                        "        \"x\": 0.5,\n" +
                        "        \"y\": 0.5,\n" +
                        "        \"r\": 1,\n" +
                        "        \"type\": \"radial\",\n" +
                        "        \"global\": false,\n" +
                        "        \"colorStops\": [\n" +
                        "         {\n" +
                        "          \"color\": \"#B8D3E4\",\n" +
                        "          \"offset\": 0\n" +
                        "         },\n" +
                        "         {\n" +
                        "          \"color\": \"#72ACD1\",\n" +
                        "          \"offset\": 1\n" +
                        "         }\n" +
                        "        ]\n" +
                        "       }\n" +
                        "      }\n" +
                        "     }\n" +
                        "    }\n" +
                        "   ]\n" +
                        "  }\n" +
                        " ]\n" +
                        "}";
                break;
            }
            case 6:
            {
                String value  = "88";
                chartoption = "{\n" +
                        " \"tooltip\": {\n" +
                        "  \"formatter\": \"{a} <br/>{b} : {c}%\"\n" +
                        " },\n" +
                        " \"toolbox\": {\n" +
                        "  \"feature\": {\n" +
                        "   \"restore\": {},\n" +
                        "   \"saveAsImage\": {}\n" +
                        "  }\n" +
                        " },\n" +
                        " \"series\": [\n" +
                        "  {\n" +
                        "   \"name\": \"业务指标\",\n" +
                        "   \"type\": \"gauge\",\n" +
                        "   \"detail\": {\n" +
                        "    \"formatter\": \"{value}%\"\n" +
                        "   },\n" +
                        "   \"data\": [\n" +
                        "    {\n" +
                        "     \"value\": " +
                        value+
                        ",\n" +
                        "     \"name\": \"完成率\"\n" +
                        "    }\n" +
                        "   ]\n" +
                        "  }\n" +
                        " ]\n" +
                        "}";
            }
            default:
                break;
        }



        chartoption = chartoption.replaceAll("\\s", "");
        System.out.println(chartoption);
        chartoption = chartoption.replaceAll("\\n", "");


        chartoption = chartoption.replaceAll("([a-zA-Z]+):","\"$1\":");
        //chartoption = chartoption.replaceAll("\'","\"");
        try {
            chartoption = URLEncoder.encode(chartoption
                    , "utf-8");

            chartoption = chartoption.replaceAll("\\+", "%20");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String urlpath = "http://localhost:3000/echarts?options="+chartoption;
        System.out.println("--------------------------------------------------");
        System.out.println(urlpath);

        try {
            URL url = new URL(urlpath);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            response.setContentType("image/png"); //设置返回的文件类型
            OutputStream os = response.getOutputStream();

            byte[] buffer = new byte[2048];
            int len = 0;
            while( (len=inStream.read(buffer)) != -1 ){
                os.write(buffer, 0, len);
            }
            inStream.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}