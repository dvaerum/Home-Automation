import com.sun.xml.internal.ws.util.StringUtils;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import java.util.ArrayList;
import java.util.*;
import javax.tools.Diagnostic;

/**
 * Created by alt_mulig on 3/26/14.
 */
public class CustomErrorListener extends DiagnosticErrorListener {

    private ArrayList<String> _errorMessages = new ArrayList<String>();
    private ArrayList<String> _warningMessages = new ArrayList<String>();
    private Boolean _captureDiagnostics;
    private String[] _file;

    public List<String> ErrorMessages() {
        return _errorMessages;
    }

    public List<String> WarningMessages() {
        return _warningMessages;
    }

    public Boolean HasErrors() {
        return _errorMessages.size() > 0;
    }

    public Boolean HasWarnings() {
        return _warningMessages.size() > 0;
    }

    public CustomErrorListener(Boolean captureDiagnosticWarnings, String file) {
        _captureDiagnostics = captureDiagnosticWarnings;
        _file = file.split("\n");
    }

    @Override
    public void syntaxError(@NotNull Recognizer<?, ?> recognizer, @Nullable Object offendingSymbol, int line, int charPositionInLine, @NotNull String msg, @Nullable RecognitionException e) {
//        System.out.println(String.format("%s", recognizer));

        String temp = String.format("line %d,%d:", line, charPositionInLine);
        _errorMessages.add(String.format("%s %s",
                           msg.replace("\\n",""),
                           //offendingSymbol.toString()));
                           ""));
        _errorMessages.add(String.format("%s %s", temp, _file[line - 1]));

        // The pointer (^) in the error msg
        if (charPositionInLine > 0) {
            _errorMessages.add(String.format("%1$" + temp.length() + "s" + "  " + "%2$" + charPositionInLine + "s\n", " ", "^"));
        } else {
            _errorMessages.add(String.format("%1$" + temp.length() + "s ^\n", " "));
        }
    }

    @Override
    public void reportAmbiguity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, boolean exact, @Nullable BitSet ambigAlts, @NotNull ATNConfigSet configs) {
        if (_captureDiagnostics) {
            _warningMessages.add(String.format("reportAmbiguity d=%s: ambigAlts=%s, input='%s'", getDecisionDescription(recognizer, dfa), getConflictingAlts(ambigAlts, configs), ((TokenStream) recognizer.getInputStream()).getText(Interval.of(startIndex, stopIndex))));
        }
    }

    @Override
    public void reportAttemptingFullContext(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, @Nullable BitSet conflictingAlts, @NotNull ATNConfigSet configs) {
        if (_captureDiagnostics) {
            _warningMessages.add(String.format("reportAttemptingFullContext d=%s, input='%s'", getDecisionDescription(recognizer, dfa), ((TokenStream) recognizer.getInputStream()).getText(Interval.of(startIndex, stopIndex))));
        }
    }

    @Override
    public void reportContextSensitivity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, int prediction, @NotNull ATNConfigSet configs) {
        if (_captureDiagnostics) {
            _warningMessages.add(String.format("reportContextSensitivity d=%s, input='%s'", getDecisionDescription(recognizer, dfa), ((TokenStream) recognizer.getInputStream()).getText(Interval.of(startIndex, stopIndex))));
        }
    }


}