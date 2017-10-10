package org.hmx.example.assertj.swing;

import java.awt.Component;
import javax.swing.JTextArea;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Test;

/**
 * Actual test class
 */
public class MainWindowTest extends AbstractUiTest {

    private JButtonFixture northButtonFixture;
    private JButtonFixture southButtonFixture;

    @Override
    protected void onSetUp() {
        this.northButtonFixture = this.frame.button(JButtonMatcher.withText("North"));
        this.southButtonFixture = this.frame.button(JButtonMatcher.withText("South"));
    }

    @Test
    public void testWithDifferingComponentMatchers() {
        // use JTextComponentMatcher.any() as there is only one text input
        this.frame.textBox(JTextComponentMatcher.any()).requireVisible().requireEnabled().requireNotEditable().requireEmpty();
        this.northButtonFixture.requireVisible().requireEnabled().click();
        // use value assigned in MainWindow class via JTextArea.setName("Center-Area") to identify component here
        this.frame.textBox("Center-Area").requireText("North, ");

        this.southButtonFixture.requireVisible().requireEnabled().click();
        // write our own matcher
        JTextComponentFixture centerArea = this.frame.textBox(new GenericTypeMatcher(JTextArea.class, true) {
            @Override
            protected boolean isMatching(Component component) {
                return true;
            }
        });
        centerArea.requireVisible().requireEnabled().requireText("North, South, ");
    }

    @Override
    protected void onTearDown() {
        this.northButtonFixture = null;
        this.southButtonFixture = null;
    }
}
