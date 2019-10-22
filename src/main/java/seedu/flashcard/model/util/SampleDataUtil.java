package seedu.flashcard.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.flashcard.model.FlashcardList;
import seedu.flashcard.model.ReadOnlyFlashcardList;
import seedu.flashcard.model.flashcard.Answer;
import seedu.flashcard.model.flashcard.Choice;
import seedu.flashcard.model.flashcard.Definition;
import seedu.flashcard.model.flashcard.Flashcard;
import seedu.flashcard.model.flashcard.McqFlashcard;
import seedu.flashcard.model.flashcard.Question;
import seedu.flashcard.model.flashcard.ShortAnswerFlashcard;
import seedu.flashcard.model.tag.Tag;

/**
 * Generate the sample data to make the default flashcard list nicer.
 */
public class SampleDataUtil {

    public static Flashcard[] getSampleFlashcards() {
        return new Flashcard[]{
            new McqFlashcard(new Question("Which of the following is true about compactness?"),
                getChoiceList("The real number space is a compact space",
                    "The complex plane is a compact space",
                    "A compact subspace of a compact metric space must be closed",
                    "A closed subspace of a compact metric space must be compact"),
                new Definition("For any open covering of a metric space, there is a finite subcover."),
                     getTagSet("mathematics", "metric space"),
                new Answer("A compact subspace of a compact metric space must be closed")),
            new McqFlashcard(new Question("Which of the following is true about completeness?"),
                getChoiceList("The rational number space is a complete space",
                    "Compact spaces are always complete",
                    "A complete subspace of a complete space myst be totally bounded",
                    "Closed subspaces in a complete metric space is also complete"),
                new Definition("Any Cauchy sequence converges in this metric space"),
                getTagSet("mathematics", "metric space"),
                new Answer("Closed subspaces in a complete metric space is also complete")),
            new ShortAnswerFlashcard(new Question("What is the 11611 meters tunnel on the boarder of France and Italy?"),
                new Definition("An amazing tunnel in Europe."),
                getTagSet("geography", "favorite"),
                new Answer("Mount Blanc Tunnel")),
        };
    }

    public static ReadOnlyFlashcardList getSampleFlashcardList() {
        FlashcardList samplefl = new FlashcardList();
        for (Flashcard flashcard : getSampleFlashcards()) {
            samplefl.addFlashcard(flashcard);
        }
        return samplefl;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a choice set containing the list of strings given.
     */
    public static List<Choice> getChoiceList(String... strings) {
        return Arrays.stream(strings)
                .map(Choice::new)
                .collect(Collectors.toList());
    }

}
