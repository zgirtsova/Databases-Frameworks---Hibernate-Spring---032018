package LAB.shape;

class Rectangle implements Drawable {
    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        System.out.println("Created an instance of a rectangle with width " + this.width
        + " and height " + this.height);
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.print("*");
            for (int k = 1; k < width - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            System.out.print("*");
            System.out.print("\n");
        }
    }

}


