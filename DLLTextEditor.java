class TextNode {
    String text;
    TextNode next;
    TextNode prev;

    TextNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextNode head = null;
    private TextNode tail = null;

    public void addText(String text) {
        TextNode newNode = new TextNode(text);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Added: \"" + text + "\"");
    }

    public void undo() {
        if (tail == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        String removed = tail.text;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Undo: \"" + removed + "\" removed");
    }

    public void display() {
        if (head == null) {
            System.out.println("Editor is empty.");
            return;
        }

        System.out.print("Current text: ");
        TextNode current = head;
        while (current != null) {
            System.out.print(current.text);
            if (current.next != null) {
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }
}


public class DLLTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addText("Hello");
        editor.display();

        editor.addText("World");
        editor.display();

        editor.undo();
        editor.display();

        editor.addText("Java");
        editor.display();

        editor.undo();
        editor.undo();
        editor.display();

        editor.undo();
    }
}
