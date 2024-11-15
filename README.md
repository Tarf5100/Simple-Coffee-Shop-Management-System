<h1>Coffee Shop Management System</h1>
<p>
    A Java-based application to manage coffee shop operations, including inventory management, menu updates, and customer order processing. 
    The project is enhanced with exception handling, file management, and a graphical user interface (GUI) for user interaction.
</p>

<h2>Features</h2>
<ul>
    <li><strong>Inventory Management</strong>:
        <ul>
            <li>Add, remove, and update items in the inventory.</li>
            <li>Restock items and track quantities.</li>
        </ul>
    </li>
    <li><strong>Menu Management</strong>:
        <ul>
            <li>Dynamically update the menu with new items (coffee and sweets).</li>
            <li>Display the current menu to users.</li>
        </ul>
    </li>
    <li><strong>Order Processing</strong>:
        <ul>
            <li>Take customer orders and calculate total prices.</li>
            <li>Check inventory availability and update quantities automatically.</li>
        </ul>
    </li>
    <li><strong>GUI Interface</strong>:
        <ul>
            <li>User-friendly interface with two frames:</li>
            <li>Input Frame: For taking customer orders or managing the inventory.</li>
            <li>Output Frame: Displays order details or inventory status.</li>
            <li>Clean and creative layout.</li>
        </ul>
    </li>
    <li><strong>Exception Handling</strong>:
        <ul>
            <li>Includes handling of checked, unchecked, and custom exceptions for a robust system.</li>
            <li>Prevents invalid inputs and operations.</li>
        </ul>
    </li>
    <li><strong>File Operations</strong>:
        <ul>
            <li>Saves user data and system updates into files.</li>
            <li>Supports reading from and writing to text or binary files for persistence.</li>
        </ul>
    </li>
</ul>

<h2>How to Run</h2>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/Tarf5100/coffee-shop-management-system.git
cd coffee-shop-management-system</code></pre>
    </li>
    <li>Compile the Java files:
        <pre><code>javac src/*.java</code></pre>
    </li>
    <li>Run the program:
        <pre><code>java src.Main</code></pre>
    </li>
</ol>

<h2>Folder Structure</h2>
<pre>
coffee-shop-management-system/
│
├── src/                                # Source code files
│   ├── CoffeeShopGUI.java              # GUI implementation
│   ├── CoffeeShopManagementSystem.java # Main management system logic
│   ├── Item.java                       # Class for inventory items
│   ├── Coffee.java                     # Class for coffee items
│   ├── Sweets.java                     # Class for sweets items
│   ├── CoffeeShop.java                 # Core class representing the coffee shop
│   ├── Order.java                      # Class for processing customer orders
│   ├── MainFrame.java                  # Main frame for GUI
│   ├── MyFrame.java                    # Custom frame for GUI components
│   ├── NegativePriceEx.java            # Custom exception for handling negative prices
│
├── images/                             # Folder for graphical assets
│   ├── coffee.png                      # Coffee icon used in the GUI
│
├── README.md                           # Project documentation
</pre>


<h2>Requirements</h2>
<ul>
    <li><strong>Java Development Kit (JDK)</strong> 8 or higher</li>
    <li><strong>IDE</strong>: IntelliJ IDEA, Eclipse, or any other Java IDE (optional for development)</li>
    <li><strong>Git</strong> (optional for version control)</li>
</ul>

<h2>Future Enhancements</h2>
<ul>
    <li>Add support for multiple users with authentication.</li>
    <li>Expand menu customization features.</li>
    <li>Enhance file management with database integration.</li>
</ul>

