package LAB.shape;

public class Main1 {
    public static void main(String[] args) {

          Drawable shape;
          shape = new Circle(8);
          shape.draw();

          shape = new Rectangle(4,8);
          shape.draw();


//        Queue<Double> queue = new ArrayDeque<>();
//
//        Drawable shape;
//
//        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
//        System.out.println("What do you want to draw: ");
//        String shapeToDraw = scan.nextLine();
//
//        if (shapeToDraw.toLowerCase().contains("circle")) {
//
//            System.out.println("Enter a radius: ");
//            Double input = Double.parseDouble(scan.nextLine());
//            queue.offer(input);
//
//            shape = new Circle(queue.poll());
//            shape.draw();
//        } else if (shapeToDraw.toLowerCase().contains("rectangle")) {
//            System.out.println("Enter width and height, separated by space: ");
//            String input = scan.nextLine();
//            String[] inputArgs = input.split(" ");
//            Double width = Double.parseDouble(inputArgs[0]);
//            Double height = Double.parseDouble(inputArgs[1]);
//            queue.offer(width);
//            queue.offer(height);
//            shape = new Rectangle(queue.poll(), queue.poll());
//            shape.draw();
//
//        } else {
//            System.out.println("Nothing to draw!");
//        }
//        System.out.println(queue.peek());
//
//        while (queue.size() > 0) {
//            System.out.println(queue.remove() + " ");
//        }
//
//        System.out.println(queue.peek());

    }
}
