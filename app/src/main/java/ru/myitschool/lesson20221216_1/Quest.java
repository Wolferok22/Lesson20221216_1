package ru.myitschool.lesson20221216_1;

public class Quest {
    private int score = 0;
    private int currentStep = 0;

    private final Question[] questions = new Question[]{
            new Question("Поднять монету (+100), поднять мешок (+1000)",
                    new Question.Answers[]{
                            new Question.Answers("Монета", 100, 1),
                            new Question.Answers("Мешок", 1000, 2)
                    }),
            new Question("Выбор следущего пути (-100)",
                    new Question.Answers[]{
                            new Question.Answers("Прямо", -100, 1),
                            new Question.Answers("Влево", -100, 1),
                            new Question.Answers("Вправо", -100, 1)
                    })
            ,
            new Question("Выбор оружия для сражения",
                    new Question.Answers[]{
                            new Question.Answers("Меч", +100, 1),
                            new Question.Answers("Лук", +100, 1)
                    })
            ,
            new Question("Встреча с мобом",
                    new Question.Answers[]{
                            new Question.Answers("Слизень (+100)", +100, 3),
                            new Question.Answers("Скелет (-100)", -100, 2),
                            new Question.Answers("Зомби (+100)", +100, 1)
                    })
            ,
            new Question("Найден сундук",
                    new Question.Answers[]{
                            new Question.Answers("Открыть (+1000)", +1000, 3),
                            new Question.Answers("Секрет", -100, -3),
                            new Question.Answers("Пройти мимо (-100)", -100, 1)
                    })
            ,
            new Question("Сундук стал мимиком",
                    new Question.Answers[]{
                            new Question.Answers("Сражаться", +1000, 1),
                            new Question.Answers("Сдаться", -1000, 1)
                    })
    };

    public int getLen() {
        return questions.length;
    }
    public void addScore(int score) {
        this.score += score;
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.length)
            return questions[index];
        return null;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public static class Question {
        private final String description;
        private final Answers[] answers;

        public String getDescription() {
            return description;
        }

        public Answers[] getAnswers() {
            return answers;
        }

        public Question(String description, Answers[] answers) {
            this.description = description;
            this.answers = answers;
        }

        public static class Answers {
            private final String name;
            private final int score;
            private final int nextStep;

            public String getName() {
                return name;
            }

            public int getScore() {
                return score;
            }

            public int getNextStep() {
                return nextStep;
            }

            public Answers(String name, int score, int nextStep) {
                this.name = name;
                this.score = score;
                this.nextStep = nextStep;
            }
        }

        }
    }



