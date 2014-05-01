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

    public List<String> ErrorMessages() {
        return _errorMessages;
    }

    private ArrayList<String> _warningMessages = new ArrayList<String>();

    public List<String> WarningMessages() {
        return _warningMessages;
    }

    public Boolean HasErrors() {
        return _errorMessages.size() > 0;
    }

    public Boolean HasWarnings() {
        return _warningMessages.size() > 0;
    }

    private Boolean _captureDiagnostics;

    public CustomErrorListener(Boolean captureDiagnosticWarnings) {
        _captureDiagnostics = captureDiagnosticWarnings;
    }

    @Override
    public void syntaxError(@NotNull Recognizer<?, ?> recognizer, @Nullable Object offendingSymbol, int line, int charPositionInLine, @NotNull String msg, @Nullable RecognitionException e) {
        _errorMessages.add(String.format("line %d:%d %s at: %s", line, charPositionInLine, msg, offendingSymbol));
        //_errorMessages.add(String.format("line %d:%d %s at: %s", line, charPositionInLine, msg, offendingSymbol.toString()));
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