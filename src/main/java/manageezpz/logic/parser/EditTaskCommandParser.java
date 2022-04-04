package manageezpz.logic.parser;

import static java.util.Objects.requireNonNull;
import static manageezpz.logic.parser.CliSyntax.PREFIX_AT_DATETIME;
import static manageezpz.logic.parser.CliSyntax.PREFIX_DATE;
import static manageezpz.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import manageezpz.commons.core.Messages;
import manageezpz.commons.core.index.Index;
import manageezpz.logic.commands.EditTaskCommand;
import manageezpz.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditTaskCommand object.
 */
public class EditTaskCommandParser implements Parser<EditTaskCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditTaskCommand
     * and returns a EditTaskCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public EditTaskCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTION, PREFIX_AT_DATETIME, PREFIX_DATE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage() + "\n\n" + EditTaskCommand.MESSAGE_USAGE, pe);
        }

        System.out.println(argMultimap.getValue(PREFIX_DESCRIPTION).isEmpty());
        System.out.println(argMultimap.getValue(PREFIX_DATE).isEmpty());
        System.out.println(argMultimap.getValue(PREFIX_AT_DATETIME).isEmpty());

        if (argMultimap.getValue(PREFIX_DESCRIPTION).isEmpty()
                && argMultimap.getValue(PREFIX_DATE).isEmpty()
                && argMultimap.getValue(PREFIX_AT_DATETIME).isEmpty()) {
            throw new ParseException(Messages.MESSAGE_FIELD_NOT_EDITED + EditTaskCommand.MESSAGE_USAGE);
        }

        String desc = argMultimap.getValue(PREFIX_DESCRIPTION).orElse("");
        String date = argMultimap.getValue(PREFIX_DATE).orElse("");
        String time = argMultimap.getValue(PREFIX_AT_DATETIME).orElse("");

        return new EditTaskCommand(index, desc, date, time);
    }
}
