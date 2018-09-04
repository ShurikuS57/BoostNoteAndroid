package com.shurikus.boostnoteandroid.parser

import org.junit.Test

class NoteParserTest {

    private val markdownNoteData = "createdAt: \"2018-08-19T07:56:22.122Z\"\n" +
            "updatedAt: \"2018-08-19T07:56:22.122Z\"\n" +
            "type: \"MARKDOWN_NOTE\"\n" +
            "folder: \"94796ba1aede73de67ac\"\n" +
            "title: \"Welcome to Boostnote!\"\n" +
            "content: '''\n" +
            "  # Welcome to Boostnote!\n" +
            "  ## Click here to edit markdown :wave:\n" +
            "  \n" +
            "  <iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/L0qNPLsvmyM\" frameborder=\"0\" allowfullscreen></iframe>\n" +
            "  \n" +
            "  ## Docs :memo:\n" +
            "  - [Boostnote | Boost your happiness, productivity and creativity.](https://hackernoon.com/boostnote-boost-your-happiness-productivity-and-creativity-315034efeebe)\n" +
            "  - [Cloud Syncing & Backups](https://github.com/BoostIO/Boostnote/wiki/Cloud-Syncing-and-Backup)\n" +
            "  - [How to sync your data across Desktop and Mobile apps](https://github.com/BoostIO/Boostnote/wiki/Sync-Data-Across-Desktop-and-Mobile-apps)\n" +
            "  - [Convert data from **Evernote** to Boostnote.](https://github.com/BoostIO/Boostnote/wiki/Evernote)\n" +
            "  - [Keyboard Shortcuts](https://github.com/BoostIO/Boostnote/wiki/Keyboard-Shortcuts)\n" +
            "  - [Keymaps in Editor mode](https://github.com/BoostIO/Boostnote/wiki/Keymaps-in-Editor-mode)\n" +
            "  - [How to set syntax highlight in Snippet note](https://github.com/BoostIO/Boostnote/wiki/Syntax-Highlighting)\n" +
            "  \n" +
            "  ---\n" +
            "  \n" +
            "  ## Article Archive :books:\n" +
            "  - [Reddit English](http://bit.ly/2mOJPu7)\n" +
            "  - [Reddit Spanish](https://www.reddit.com/r/boostnote_es/)\n" +
            "  - [Reddit Chinese](https://www.reddit.com/r/boostnote_cn/)\n" +
            "  - [Reddit Japanese](https://www.reddit.com/r/boostnote_jp/)\n" +
            "  \n" +
            "  ---\n" +
            "  \n" +
            "  ## Community :beers:\n" +
            "  - [GitHub](http://bit.ly/2AWWzkD)\n" +
            "  - [Twitter](http://bit.ly/2z8BUJZ)\n" +
            "  - [Facebook Group](http://bit.ly/2jcca8t)\n" +
            "'''\n" +
            "tags: []\n" +
            "isStarred: false\n" +
            "isTrashed: false"

    @Test
    fun `parse markdown note`() {
        val note = NoteParser.parse(markdownNoteData)
        assert(note.createdAt == "2018-08-19T07:56:22.122Z")
        assert(note.updatedAt == "2018-08-19T07:56:22.122Z")
        assert(note.type == "MARKDOWN_NOTE")
        assert(note.folder == "94796ba1aede73de67ac")
        assert(note.title == "Welcome to Boostnote!")
        assert(note.createdAt == "2018-08-19T07:56:22.122Z")
        assert(note.isStarred == false)
        assert(note.isTrashed == false)
    }
}