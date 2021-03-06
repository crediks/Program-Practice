import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import roctime.TimeService;


public class Client {

	public static void main(String[] args) {

		try {
			TTransport transport;
			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			TimeService.Client client = new TimeService.Client(protocol);
			perform(client);
			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
	}

	private static void perform(TimeService.Client client) throws TException {
		System.out.println("Ping()...");
		int time = client.TellMeTime();
		System.out.println(time);
	}
}
