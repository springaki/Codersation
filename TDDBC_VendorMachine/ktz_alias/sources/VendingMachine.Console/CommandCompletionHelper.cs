using System;
using System.Collections.Generic;
using System.Linq;

namespace VendingMachine.Console {
    public static class CommandCompletionHelper {
        public static IEnumerable<HelpContent> ListHelpContents() {
            return  new HelpContent[] {
                new HelpContent {
                    Command = "ins", 
                    Description = "To insert money is requested.",
                    Usage = "ins <money value> [<count>] (where counter is > 0 and <= 100)",
                },
                new HelpContent {
                    Command = "buy",
                    Description = "",
                    Usage = "",
                    Ignored = true
                },
                new HelpContent {
                    Command = "show item",
                    Description = "To display the layouted items is requested.",
                    Usage = "show item",
                },
                new HelpContent {
                    Command = "show amount",
                    Description = "To display the total amount of money inserted is requested.",
                    Usage = "show amount",
                },
                new HelpContent {
                    Command = "eject", 
                    Description = "To eject inserted money is requested.",
                    Usage = "eject",
                },
                new HelpContent {
                    Command = "help",
                    Description = "This message(s) is displayed.",
                    Usage = "help [<command name>]"
                }
            };
        }

        public static IEnumerable<string> ListCommands() {
            return ListHelpContents().Select(content => content.Command);
        }
    }
}

