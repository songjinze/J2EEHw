package beans;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBean {
    private List<String> productNames=new ArrayList<>();
    private List<Integer> productNums=new ArrayList<>();

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<Integer> getProductNums() {
        return productNums;
    }

    public void setProductNums(List<Integer> productNums) {
        this.productNums = productNums;
    }
}
