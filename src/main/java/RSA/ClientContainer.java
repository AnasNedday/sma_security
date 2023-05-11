package RSA;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ClientContainer {

    public static void main(String[] args) throws ControllerException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer agentContainer=runtime.createAgentContainer(profile);
        String encodedPbk="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALP4btKv2tkVAs/Ymw934DMTLe0DqJz12A7TuiJGueZtx5qDvXjrCcQlninDxFvXbxAVEV27ZYLYV5Y8xdqLuY8CAwEAAQ==";

        AgentController client = agentContainer.createNewAgent("client", ClientAgent.class.getName(), new Object[]{encodedPbk});
        client.start();
    }

}
