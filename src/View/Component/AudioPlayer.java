package View.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.BufferedInputStream;
import java.io.InputStream;

public final class AudioPlayer {

    public void tocarAudio(String caminhoRecurso,float v) {
        new Thread(() -> {
            try {
                InputStream audioSrc = getClass().getResourceAsStream(caminhoRecurso);
                if (audioSrc == null) {
                    System.out.println("Arquivo não encontrado: " + caminhoRecurso);
                    return;
                }
                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(v);

                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
