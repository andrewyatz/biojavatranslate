package uk.ac.ebi;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

  public static Test suite() {
    return new TestSuite( AppTest.class );
  }

  public void testApp() {
    App app = new App();
    try {
      DNASequence dna = new DNASequence("atgtcaatggtaagaaatgtatcaatcagagcgaaaaattggaaattttgt");
      ProteinSequence protein = app.toProteinSequence(dna);
      assertEquals("MSMVRNVSIRAKNWKFC", protein.toString());
    }
    catch(CompoundNotFoundException e) {
      fail("Compound not found");
    }
  }
}
