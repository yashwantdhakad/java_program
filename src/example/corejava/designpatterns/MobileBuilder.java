package example.corejava.designpatterns;

class MobileBuilder {
    private String model;
    private int price;

    private MobileBuilder(BuilderClass builder) {
        this.model = builder.model;
        this.price = builder.price;
    }

    public static class BuilderClass {
        private String model;
        private int price;

        public BuilderClass() {}

        public BuilderClass setModel(String model) {
            this.model = model;
            return this;
        }

        public BuilderClass setPrice(int price) {
            this.price = price;
            return this;
        }

        public MobileBuilder build() {
            return new MobileBuilder(this);
        }

    }
    @Override
    public String toString() {
        return "MobileBuilder{model='" + model + "', price=" + price + "}";
    }

    public static void main(String[] args) {
        MobileBuilder mobile = new MobileBuilder.BuilderClass()
                .setModel("Iphone")
                .setPrice(12000)
                .build();
        System.out.println(mobile);
    }
}
