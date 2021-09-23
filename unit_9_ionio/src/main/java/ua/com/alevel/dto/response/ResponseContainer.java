package ua.com.alevel.dto.response;

public class ResponseContainer<D> {

    private D data;

    public ResponseContainer(D data) {
        this.data = data;
    }
    public ResponseContainer() {}

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
