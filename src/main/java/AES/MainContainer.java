package AES;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;


public class MainContainer {

    public static void main(String[] args) throws ControllerException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter("port","1099");
        profile.setParameter("gui","true");
        AgentContainer agentContainer=runtime.createMainContainer(profile);
        agentContainer.start();
    }

}
