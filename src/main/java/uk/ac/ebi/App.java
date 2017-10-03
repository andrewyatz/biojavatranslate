package uk.ac.ebi;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.core.sequence.transcription.TranscriptionEngine;

/**
 * Hello world!
 *
 */
public class App {
  public static void main( String[] args ) throws Exception {
    File fastaFile = new File(args[0]);
    LinkedHashMap<String, DNASequence> seqs = FastaReaderHelper.readFastaDNASequence(fastaFile, false);
    App app = new App();
    for(Map.Entry<String,DNASequence> e:  seqs.entrySet()) {
      ProteinSequence p = app.toProteinSequence(e.getValue());
    }
  }

  private TranscriptionEngine transcriber = TranscriptionEngine.getDefault();

  public ProteinSequence toProteinSequence(DNASequence dna) {
    RNASequence r = dna.getRNASequence(transcriber);
    ProteinSequence p = r.getProteinSequence(transcriber);
    return p;
  }
}
