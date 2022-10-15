package eam.after;

public class UseResource {

    public static void main(String[] args) {
//        Resource r = new Resource();
//        try {
//            r.op1();
//            r.op2();
//        } finally {
//            r.close();
//        }

        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });
        Resource resource = Resource.useWithReturn(r -> {
            r.op1();
            r.op2();
            return r;
        });

    }
}
