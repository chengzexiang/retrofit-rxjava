package com.bwei.czx.czx1102study2;

/**
 * lenovo 刘珂珂
 * 2017/11/2
 * 11:05
 */

public class BookEntity {

    /**
     * errNo : 0
     * errMsg : OK
     * data : {"id":4,"title":"娣卞叆娴呭嚭MySQL","type":"鏁版嵁搴�","description":"MySQL鍘熷垱鍥句功涔嬩竴锛岀綉鏄撴妧鏈儴DBA缁勬椂闅�5骞村啀鐚姏浣滐紝鎶奙ySQL鐢ㄥ埌楂樺鐣岀殑瀹炶返锛岄珮鎬ц兘mysql鎸囧鎸囧崡锛宮ysql鏁版嵁搴撳繀澶囧疂鍏革紒","picture":"http://img10.360buyimg.com/n1/g13/M01/11/06/rBEhU1LQxrAIAAAAAAKmO7XSO1AAAH0uQBQfwoAAqZT742.jpg","isRecommend":false,"dtCreated":"00-00 00:04"}
     */

    private int errNo;
    private String errMsg;
    private DataBean data;

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * title : 娣卞叆娴呭嚭MySQL
         * type : 鏁版嵁搴�
         * description : MySQL鍘熷垱鍥句功涔嬩竴锛岀綉鏄撴妧鏈儴DBA缁勬椂闅�5骞村啀鐚姏浣滐紝鎶奙ySQL鐢ㄥ埌楂樺鐣岀殑瀹炶返锛岄珮鎬ц兘mysql鎸囧鎸囧崡锛宮ysql鏁版嵁搴撳繀澶囧疂鍏革紒
         * picture : http://img10.360buyimg.com/n1/g13/M01/11/06/rBEhU1LQxrAIAAAAAAKmO7XSO1AAAH0uQBQfwoAAqZT742.jpg
         * isRecommend : false
         * dtCreated : 00-00 00:04
         */

        private int id;
        private String title;
        private String type;
        private String description;
        private String picture;
        private boolean isRecommend;
        private String dtCreated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public boolean isIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(boolean isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getDtCreated() {
            return dtCreated;
        }

        public void setDtCreated(String dtCreated) {
            this.dtCreated = dtCreated;
        }
    }
}
