package manageezpz.logic.parser;

import static manageezpz.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT_BIND;
import static manageezpz.logic.parser.CommandParserTestUtil.assertParseFailure;
import static manageezpz.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static manageezpz.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import manageezpz.logic.commands.MarkTaskCommand;

public class MarkTaskCommandParserTest {

    private MarkTaskCommandParser parser = new MarkTaskCommandParser();

    @Test
    public void parse_validCommand_returnsMarkTaskCommand() {
        assertParseSuccess(parser, "1", new MarkTaskCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidCommandEmpty_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT_BIND, MarkTaskCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidCommandContainsSpace_throwsParseException() {
        assertParseFailure(parser, "1 a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT_BIND, MarkTaskCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, "a",
                ParserUtil.MESSAGE_INVALID_INDEX + "\n\n" + MarkTaskCommand.MESSAGE_USAGE);
    }
}
