import java.io.IOException;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Oliver {
    //declaring voice
    private static final String voice = "kevin16";
    public static void main(String[] st) {


        Voice v;
        VoiceManager voiceManager = VoiceManager.getInstance();
        v = voiceManager.getVoice(voice);//assigning voice in the Voice type
        v.allocate();

        //configuration for the listening your voice
        Configuration config = new Configuration();

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");//hard coded path
        config.setDictionaryPath("src\\main\\resources\\1841.dic");//need to make file from sphinx knowledge base convertor
        config.setLanguageModelPath("src\\main\\resources\\1841.lm");

        String com;

        try {
            //making system understand you are speaking
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            SpeechResult speechResult = null;
            System.out.println("listening");
            //running until user is speaking
            while ((speechResult = speech.getResult()) != null) {
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice Command is " + voiceCommand);

                if (voiceCommand.equalsIgnoreCase("oliver Open Chrome")) {
                     com = "opening chrome";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c start chrome");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close chrome")){
                    com = "closing chrome";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver open youtube")){
                     com = "opening youtube";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c start chrome www.youtube.com");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close youtube")) {
                    com = "closing youtube";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver open calculator")) {
                     com = "opening calculator";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c start calc");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close calculator")) {
                     com = "closing calculator";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c /T TASKKILL /IM calculator.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver open sublimetext")) {
                     com = "opening sublime text";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c start subl");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close sublimetext")) {
                     com = "closing sublime text";
                    v.speak(com);
                    Runtime.getRuntime().exec("cmd.exe /c taskkill  /IM sublime_text.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver terminate")) {
                     com = "oliver shutting down";
                    v.speak(com);
                    System.exit(0);
                }else{
                    v.speak("cannot understand please repeat");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

