package com.example.admin.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duskcloud on 2017/12/9.
 */

public class networkAccessing_response {
    public class data {
        private class yesterday {
            public String date;
            public String high;
            public String fx;
            public String low;
            public String fl;
            public String type;
        }

        public yesterday yesterday;
        public String city;
        public String aqi;

        private class forecast {
            public String date;
            public String high;
            public String low;
            public String fengxiang;
            public String type;
        }

        public ArrayList<forecast> forecast;
        public String ganmao;
        public String wendu;

        public ArrayList<String> getresult() {
            ArrayList<String> result = new ArrayList<>();
            result.add("yesterday");
            result.add(yesterday.date);
            result.add(yesterday.high);
            result.add(yesterday.fx);
            result.add(yesterday.fl);
            result.add(yesterday.low);
            result.add(yesterday.type);
            result.add("forecasts");
            int current = 1;
            for (forecast i : forecast) {
                result.add("后" + current + "天天气预报：");
                result.add(i.date);
                result.add(i.high);
                result.add(i.low);
                result.add(i.fengxiang);
                result.add(i.type);
            }
            return result;

        }
    }

    public data data;
    public int status;
    public String desc;


}
