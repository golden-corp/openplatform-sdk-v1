package com.golden;

    public class EnvEnum {

        enum URL {

            TEST("http://182.254.219.106:8400"),

            PROD("https://openapi.fapiaoer.cn");

            private String url;

            URL(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

    }
