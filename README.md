# BioJava Translate

## Building the JAR

```bash
mvn package
```

## Running the JAR

```bash
java -jar target/biojavatranslate-jar-with-dependencies.jar test-dna.fa
```

# Example Java Code for Translating a DNA Sequence into Proteins

```java
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.transcription.TranscriptionEngine;

public class App {
  public static void main(String[] args) throws Exception {
    TranscriptionEngine transcriber = TranscriptionEngine.getDefault();
    DNASequence d = new DNASequence("atgtcaatggtaagaaatgtatcaatcagagcgaaaaattggaaattttgt");
    RNASequence r = e.getValue().getRNASequence(transcriber);
    ProteinSequence p = r.getProteinSequence(transcriber);
  }
}
```
