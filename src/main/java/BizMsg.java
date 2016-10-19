

import java.util.List;

public class BizMsg<T> {

    private String code;
    private String msg;
    private List<T> data;// 按列表返回data


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getDataList() {
        return data;
    }

    public void setDataList(List<T> dataList) {
        this.data = dataList;
    }

    @Override
    public String toString() {
        return "BizMsg [code=" + code + ", msg=" + msg + ", dataList=" + data + "]";
    }


}
