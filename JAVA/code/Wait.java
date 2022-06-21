public class Wait {
    public static void slow() throws InterruptedException {
        String[] days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
        };

        for (String d : days) {
            Thread.sleep(1000);
            System.out.println( d );
        }

    }

    public static void main(String[] args) {
        try {
            // slow();
            String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
            };

            for (String d : days) {
                Thread.sleep(100);
                System.out.println( d );
            }
        } catch( InterruptedException e)  {
            System.out.println( "stop it!" );
        }
    }
}
