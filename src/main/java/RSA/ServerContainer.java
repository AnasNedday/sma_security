package RSA;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ServerContainer {

    public static void main(String[] args) throws ControllerException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer agentContainer=runtime.createAgentContainer(profile);
        String encodedPrk="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAs/hu0q/a2RUCz9ibD3fgMxMt7QOonPXYDtO6Ika55m3HmoO9eOsJxCWeKcPEW9dvEBURXbtlgthXljzF2ou5jwIDAQABAkARnK7PvHjoxJcdWv+1sFAG/4n/h1uhXKezr8Gn6A76PzsEof/2XRcpM9gHe4g15k/ukRbrgeMvuKzSTEHEbCJhAiEA2hi+RDbqEmgZ4WGoNbQZIGxDaOz/Vf8aFkSrO1DvQ28CIQDTP2473235rtS+gUZMoyHYDg3U4fvCLGSaQIqSwMdb4QIhALEsmKTh15XMa/nkU7oM7LyiNsDuhx9dddvRPSmavkSRAiAez9atRvaMf5KqQsLVNMof8FTWIywMc1stIJLVuuaZIQIhALFSUCaonBsxViay5Ex9LLp4PZ8J9N5RJ9qG3fVCDXYJ";
        AgentController server = agentContainer.createNewAgent("server", ServerAgent.class.getName(), new Object[]{encodedPrk});
        server.start();

    }

}
