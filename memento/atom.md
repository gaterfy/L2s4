# Atom shortcuts

### Basic shortcuts

* `Ctrl + Shift + P` : open command palette.
* `Ctrl + ,` : open settings.
* `Ctrl + O` : open a file.
* `Ctrl + Alt + O` : open a folder.
* `Ctrl + N` : new file.
* `Ctrl + S` : save a file.
* `Ctrl + Shift + S` : save as.
* `Ctrl + K` `Ctrl + B` : toggle tree view.
* `Alt + \` : focus tree view.
	* `A` : add new file.
	* `M` : move selected file.
	* `Delete` : delete selected file/folder.
* `Ctrl + T` or `Ctrl + P` : quickly search file in the project you've opened.
* `Ctrl + B` : search through files currently opened.
* `Ctrl + Shift + B` : search through new/modified files since the last git commit.
* `Alt + Shift + S` : See all the available snippets.
* `Ctrl + K` `Up/Down/Left/Right` : split current pane horizontally/vertically.
* `Ctrl + K` `Ctrl + Up/Down/Left/Right` : switch between different panes.
* `Ctrl + Shift + L` : choose the Grammar of the text.

### Moving in Atom

* `Ctrl + Left/Right` : move to the beginning/end of a word.
* `Home` : move to the beginning of the line.
* `End` : move to the end of the line.
* `Ctrl + Home/End` : move to the beginning/end of file.
* `Ctrl + G` : move to a specific line.
* `Ctrl + R` : navigate by symbols.
* `Ctrl + Shift + F2` : add a bookmark.
* `Ctrl + F2`: see all bookmarks.
* `F2` : navigate to the next bookmark.
* `Shift + F2` : navigate to the previous bookmark.
* `Alt + Shift + F2` : clear all bookmarks.

### Selecting in Atom

* `Shift + Up/Down` : select up/down.
* `Shift + Right/Left` : select next/previous character.
* `Ctrl + Shift + Left/Right` : select to beginning/end of word.
* `Ctrl + Shift + Home/End` : select to top/end of file.
* `Ctrl + A` : select the entire contents of file.
* `Ctrl + L` : select the entire line.
* `Ctrl + Shift + M` : toggle markdown preview.

### Editing and deleting text in Atom

* `Ctrl + J` : join the next line to the end of the current line.
* `Ctrl + Up/Down` : move the current line up/down.
* `Ctrl + Shift + D` : duplicate the current line.
* `Ctrl + K` `Ctrl + U/L` : Upper/Lower case the current word.
* `Ctrl + Shift + K` : delete the current line.
* `Ctrl + Backspace` : delete to beginning of the word.
* `Ctrl + Delete` : delete to the end of the word.
* `Ctrl + Click` : add a new cursor.
* `Alt + Shift Up/Down` : Add a new cursor above/below the current cursor.
* `Ctrl + D` : select the next word that is the same as the current selected word.
* `Alt + F3` : select all words that are the same as the current selected word.
* `Ctrl + M` : Jump to the bracket matching the one adjacent to the cursor. It jumps to the nearest enclosing bracket when there's no adjacent bracket.
* `Alt + Ctrl + M` : Select all text inside the current brackets.
* `Alt + Ctrl + .` : Close the current XML/HTML tag.
* `Alt + U` : Change file encoding.

### Searching in Atom

* `Ctrl + F` : Search in the current file.
* `Ctrl + Shift + F` : Search in the current project.
    * `Enter` or `F3` : Find next.

### GitHub and Atom

* `Alt + G` `O` : open file on GitHub.
* `Alt + G` `B` : Open Blame view of file on GitHub.
* `Alt + G` `H` : Open History view of file on GitHub.
* `Alt + G` `C` : Copy the URL of the current file on GitHub to the clipboard.
* `Alt + G` `R` : Branch compare on GitHub.

### Atom packages

* `Ctrl + Shift + P` then `Generate Package` : Creates a new package.

* The flow :
	1. Atom starts up
	2. Atom starts loading packages
	3. Atom reads your package.json
	4. Atom loads keymaps, menus, styles and the main module
	5. Atom finishes loading packages
	6. At some point, the user executes your package command 	`your-name-word-count:toggle`
	7. Atom executes the activate method in your main module 	which sets up the UI by creating the hidden modal view
	8. Atom executes the package command 	`your-name-word-count:toggle` which reveals the hidden modal view
	9. At some point, the user executes the your-name-word-count:toggle command again
	10. Atom executes the command which hides the modal view
	11. Eventually, Atom is shut down which can trigger any 	serializations that youpackage has defined

----
For more details, go [here](http://flight-manual.atom.io/)
