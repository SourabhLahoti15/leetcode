class ProductOfNumbers {
    ArrayList<Integer> preProduct = new ArrayList<>();
    int size = 0;
    public ProductOfNumbers() {
        this.preProduct.add(1);
        this.size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            this.preProduct = new ArrayList<>();
            this.preProduct.add(1);
            this.size = 0;
        } else {
            this.preProduct.add(this.preProduct.get(size) * num);
            this.size++;
        }
    }
    
    public int getProduct(int k) {
        if (k > this.size) return 0;
        return (this.preProduct.get(size) / this.preProduct.get(this.size-k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */