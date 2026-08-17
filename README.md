# SNHU-CS250-Project-Portfolio
# Description: Repository containing work from CS-250: Software Development Lifecycle

# 📘Project: Agile Frameworks - My Full SDLC Project Showcase
# Student Name: Deepesh Koirala
# Professor: Deron Dantzler
# Module Range: From Module 1 to Module 7

🏗️ Module 1: SDLC Foundations & Agile Concepts
When I began Module 1, my understanding of software development was heavily focused on coding—writing syntax, debugging errors, and getting a program to run. However, this module fundamentally shifted my perspective. I learned that software development is not a linear, code-first process; it is a structured, cyclical journey known as the Software Development Lifecycle (SDLC).

I studied the various phases of the SDLC: Planning, Analysis, Design, Implementation, Testing, Deployment, and Maintenance. I realized that writing code is just one small piece of a much larger puzzle. If a project moves straight to coding without proper planning and analysis, it almost always fails due to misaligned expectations.

In this module, I also delved into Agile methodology for the first time. I learned that Agile is built on iterative development, where requirements and solutions evolve through collaboration between self-organizing, cross-functional teams. This was a significant "aha" moment for me. Instead of waiting until the very end to show a client a finished product, Agile advocates for delivering small, working pieces of functionality frequently, gathering feedback, and adapting continuously.

📝 Module 2: The Product Backlog, User Stories, and Discussion Dynamics
Module 2 was where the theoretical concepts from Module 1 became practical. I was introduced to the Product Backlog—a living, prioritized list of everything that needs to be built for a project. I learned that the Product Owner is responsible for maintaining this backlog, ensuring that the highest-value items are at the top and ready for the development team to work on in upcoming sprints.

A critical part of this module was learning how to write effective User Stories. I practiced writing user stories using the standard template:
"As a [type of user], I want [some goal] so that [some reason]."

For the SNHU Travel project, I conceptualized user stories like:
"As a traveler, I want to see a list of top-rated destinations so that I can quickly decide where to book my next vacation."
"As a returning user, I want to see personalized recommendations based on my past bookings so that the website feels tailored to my preferences."
"As a budget-conscious traveler, I want to filter destinations by price so that I can stay within my spending limit."

I also learned about Acceptance Criteria—the specific conditions that a user story must meet for it to be considered "done." For example, for the destination list story, the criteria included: "The list must display exactly 5 destinations," "Each destination must have an image," and "Clicking a destination must open a booking link."

Additionally, we engaged in a class discussion regarding how Agile teams operate. We discussed the importance of daily stand-up meetings, sprint reviews, and retrospectives. Through this discussion, I realized that communication is just as important as technical skills. In a real-world development environment, developers constantly communicate with Product Owners to clarify requirements and with QA testers to fix bugs. This module taught me that software engineering is fundamentally a collaborative discipline.

💻 Module 3: Implementation - Building the Top 5 Destinations List
In Module 3, I transitioned from planning to actual coding. I was tasked with building the Minimum Viable Product (MVP) for SNHU Travel: a static list of the top 5 travel destinations using Java Swing.

I developed the TopFiveDestinationList.java application. This was my first hands-on experience building a Graphical User Interface (GUI) in Java. I utilized the JList component to display the destinations and wrote a custom ListCellRenderer to control how each item looked. Each list item contained a destination name, a short one-sentence description, and a thumbnail image.

One of the key technical hurdles I overcame was resource management. The assignment required me to load five copyright-free images (sourced from Unsplash) into the application. I quickly learned that Java Swing does not always handle relative file paths intuitively. To ensure robustness, I wrote a helper method (loadImage) that tried to load images from three different locations: the current working directory, the resources folder, and the class loader. This was my first taste of defensive programming-anticipating potential failures and writing code to handle them gracefully.

The most satisfying feature I implemented in Module 3 was interactive linking. I added a MouseAdapter to the list so that when a user clicked on a destination, the application would automatically launch the user's default web browser and navigate to the specific SNHU Travel booking URL for that package. This transformed the application from a static display into a functional, user-friendly tool.

Writing Formal Emails to the Product Owner and Tester:
During this module, I also engaged in professional communication to ensure the requirements were clear. I drafted formal emails to the simulated Product Owner and the Tester.

To the Product Owner: I clarified the acceptance criteria for the top destinations feature, asking specific questions about whether the destinations should be ranked by popularity, region, or wellness focus. This ensured that when I wrote the code, I was building exactly what the business needed, rather than guessing.

To the Tester: I provided context about my code changes and asked for feedback on the clickable links and image loading features I implemented.
These emails taught me that clear, written communication is essential in software development, as it creates a paper trail and ensures everyone is aligned on the same expectations.

🧪 Module 4: Formal Testing and Adapting to Change
Module 4 marked my transition into the Quality Assurance (QA) phase. I realized early on that writing code is only half the battle-ensuring that code works correctly under all circumstances is what separates a hobbyist project from a professional software product.

I created a comprehensive Test Case Template in Excel to validate my work. The template included columns for Test Case ID, Test Name, Owner, Pre-Conditions, Test Steps, Inputs, and Expected Results. This structure forced me to think like a QA engineer.

I wrote TC-001 for my list-based application, verifying that:
The page displayed 5 destinations.
The destinations were ordered from #1 to #5.
Each listing contained a picture, a short description, and a clickable link.

However, Module 4 introduced an important concept: change is inevitable in software development. I received a notification from the Product Owner (simulated by the assignment prompt) that the design had changed. The new wireframe dictated that the destinations should no longer be displayed as a list, but rather as a slideshow.

This was a crucial learning moment. Instead of panicking or clinging to my original code, I embraced the Agile principle of "responding to change over following a plan." I immediately revised my test case to TC-001-R (Revised), retitling it "Top Five Destinations List (Slideshow Version)" and updating the test steps to verify slideshow navigation, image loading, and button functionality.

I also wrote TC-002 (Personalized Destinations) and TC-003 (Price Limit Filtering). For these, I went beyond simple "happy path" testing. I deliberately included edge cases, such as:
Entering a non-numeric value (e.g., "abc") in the price field.
Entering a negative number (e.g., "-500").
Testing a very low price limit ($50) to ensure the system displayed a helpful "no results" message.

Through this module, I learned that a well-written test case is a powerful communication tool. It bridges the gap between the Product Owner's requirements (the wireframe) and the developer's implementation.

🖥️ Module 5: The Major Pivot - Building the Slideshow Application
Module 5 was the most intensive coding module of the course. Based on the revised test cases and wireframe from Module 4, I completely refactored my application. I deleted the list-based UI and built a brand-new slideshow application using Java Swing's CardLayout-as a developer.

I created the SlideShow.java file, which featured a robust, polished UI. I designed the application window to be 900x700 pixels, providing enough space for high-quality imagery. A title label, "Top 5 Wellness Destinations," was placed at the top, and a navigation panel with "Previous" and "Next" buttons was placed at the bottom.

The core of the application was the CardLayout panel, which allowed me to stack five separate slides on top of one another and switch between them programmatically. Each slide was divided into two main areas:
A large image (850x470): I scaled the images using Image.getScaledInstance() to ensure they fit perfectly without stretching or distortion.
A blue interactive text box: This box displayed the destination's rank, name, country, a wellness focus tag (e.g., "Best for Geothermal Healing"), and a short description.

One of the features I am most proud of is the interactive feedback I built into the text box. Using MouseAdapter, I programmed the box to:
Turn a lighter shade of blue when the user hovers over it, providing visual feedback.
Flash briefly when clicked.
Immediately open the correct booking URL in the browser upon click.
I also made the images clickable, so users could click either the picture or the text box to book their trip. This attention to User Experience (UX) was a direct result of the user stories I had learned about in Module 2; I was now delivering a product that was not only functional but also intuitive.

Finally, I packaged the entire application into a Runnable JAR file (SlideShow.jar). This involved bundling the resources folder (containing all 5 images) and the required Java libraries (org packages) into a single executable. This step taught me how to prepare a software product for actual delivery to a client.

🧑‍🤝‍🧑 Module 6: Group Discussions and the Agile Transition
Module 6 was a pivotal moment in the course because it shifted the focus from individual coding to team dynamics and process adoption. I stepped into a more collaborative role, engaging deeply with my peers and simulating real-world software team interactions.

Group Discussion: The Waterfall-to-Agile Transition for Vision Quest
One of the most meaningful activities in Module 6 was a group discussion where our team simulated a real-world scenario: a company transitioning from the Waterfall methodology to Agile. We assumed various Scrum roles—Product Owner, Scrum Master, Developers, and Testers—and debated the pros and cons of this shift.

We discussed a hypothetical company named "Vision Quest", which had historically used Waterfall. The team identified several pain points in their Waterfall approach:
Long delivery cycles that delayed customer feedback.
High risk of building the wrong product because requirements were locked in at the start.
Difficulty adapting to market changes mid-project.

As a group, we concluded that adopting Agile was the right decision for Vision Quest because:
Iterative delivery allows the team to show working software to stakeholders every few weeks.
Customer collaboration (over contract negotiation) ensures the product actually solves user problems.
Embracing change means the team can pivot if competitors release a new feature or if customer preferences shift.

This group discussion deepened my understanding of Agile philosophy. It wasn't just about writing code faster-it was about building the right product and building it in a way that minimizes waste and maximizes value. I also learned that transitioning from Waterfall to Agile is not easy; it requires a cultural shift where everyone, from management to developers, must be open to new ways of working.

🛠️ Module 7: Sprint Reviews, Retrospectives, and Proving Agile's Value
Module 7 was the culminating project phase where I focused on evaluating the Agile process and proving its superiority over Waterfall through practical demonstration. While I had worn many hats throughout the semester—acting as a Product Owner to define requirements, a Developer to build the slideshow, and a Tester to validate it; in Module 7, I focused on creating the Sprint Review and Retrospective presentations for both the Chada Tech and SNHU Travel projects.

Demonstrating the Success of Agile for Chada Tech and SNHU Travel
My goal in Module 7 was to show Chada Tech and SNHU Travel why adopting an Agile methodology was a better choice than sticking with Waterfall. I did this by practically demonstrating the success of my workable, interactive website application (the SNHU Travel slideshow) and explaining how Agile made it possible. By showing a fully functional, user-tested product that was built iteratively and adapted to changing requirements, I proved that Agile delivers real, tangible value faster than the rigid Waterfall model.

Demonstrating How Scrum Roles Contributed to the Project's Success
In my Module 7 presentations, I clearly demonstrated how the various roles on a Scrum-Agile team specifically contributed to the success of this project. Even though I acted as a solo developer mostly throughout the course, I explained how these scrums roles operate in a real-world scenario:
The Product Owner provides the vision and prioritizes the Product Backlog, ensuring the team is always building the most valuable features first.
The Scrum Master facilitates the Agile process, removes blockers, and ensures the team adheres to Scrum principles.
The Developers execute the technical work, write clean code, and ensure the product meets the Acceptance Criteria.
The Testers ensure quality by writing and executing test cases, catching bugs early in the cycle.

I explained that the success of the SNHU Travel slideshow was a direct result of these roles functioning together efficiently within the Scrum framework.

Describing How Agile Helped User Stories Come to Completion
In my presentation, I also described how the Scrum-Agile approach to the SDLC helped user stories come to completion. I referenced the specific user stories I had written earlier in the course (e.g., "As a traveler, I want to see a list of top-rated destinations..."). I explained that by breaking these stories down into small, manageable tasks with clear Acceptance Criteria, I was able to complete them in short, focused sprints. The iterative nature of Agile allowed me to deliver a working list in Module 3, receive feedback from the Product Owner, and then pivot to the slideshow in Module 5-all while keeping the user stories at the center of my development efforts.

Evaluating Organizational Tools and Agile Principles
During the presentations, I evaluated the organizational tools and Scrum-Agile principles that were used throughout the project:
Scrum Ceremonies: I discussed how daily stand-ups, sprint planning, sprint reviews, and retrospectives keep a team aligned and focused on continuous improvement.
The Product Backlog: I explained how maintaining a prioritized backlog ensures that the team is always working on the most critical features.
Burndown Charts and Velocity: I touched on how tracking progress helps teams predict when work will be completed and adjust their commitments accordingly.
Definition of Done: I highlighted how having a clear "Done" criteria prevents misunderstandings and ensures quality.

Assessing the Effectiveness of the Scrum-Agile Approach
Finally, I assessed the effectiveness of the Scrum-Agile approach. I concluded that Agile was highly effective for this project because:
It saved time and money: I built a working prototype early on and adapted quickly to the new wireframe, avoiding costly rework.
It increased customer satisfaction: By involving the Product Owner (simulated) at every stage, the final product aligned perfectly with their vision.
It reduced risk: Testing and validation occurred continuously throughout the lifecycle, not just at the very end.

My Takeaway from Module 7
Module 7 taught me that Agile is not just a buzzword; it is a proven framework for delivering successful software. By creating the Sprint Review and Retrospective presentations as a Scrum Master, I proved that I can not only build software, but also analyze, justify, and defend the methodologies used to build it. I demonstrated that I understand the "big picture" of software development: the people, the processes, and the principles that turn a simple user story into a successful, deployed product.

🎯 Final Reflection: My Journey from Module 1 to Module 7
Looking back at the entire course, I am amazed at how much my perspective has evolved.

At the start of Module 1, I viewed software development as a solitary endeavor focused on writing correct syntax. I thought a successful project was simply one that ran without crashing.

Today, I understand that a successful project is much more than that. It is a product that solves a user's problem, meets the business's financial goals, and is built by a collaborative team following a structured, iterative process. The software runs without crashing, of course, but that is just the baseline. The real measure of success is customer satisfaction, maintainability, and adaptability.

The SNHU Travel slideshow application I built in Module 5 is a perfect artifact of this learning journey. It began as a simple list (Module 3), was rigorously defined in test cases (Module 4), pivoted to a new design based on client feedback, and was finally delivered as a polished, executable JAR. Every step of the way, I used the concepts I learned in the previous modules to guide my decisions.

But beyond the code, my experience in Modules 6 and 7 taught me the most. I learned that a development team is only as strong as its communication. By engaging in group discussions about the Waterfall-to-Agile transition, I learned how to guide a team toward continuous improvement. By preparing and delivering Sprint Reviews and Retrospectives, I proved that I could evaluate software processes and justify their effectiveness to my scrum team, product owner and to the clients or stakeholders.

As I move forward in my academic and professional career, I will carry these lessons with me:
Always start with the user. The code is meaningless if it does not solve a real problem.
Test early and test often. Catching bugs early saves time, money, and reputation.
Embrace change; it is not a failure, it is an opportunity. The best software adapts to the world around it.
Communicate clearly and collaborate generously. Software is built by teams, not by individuals.

This course has not just taught me how to build software; it has taught me how to be a professional software engineer. I am ready for the next challenge.

✅ Final Repository Deliverables (For Submission)
To demonstrate this full lifecycle, my final repository submission includes:
README.md – A comprehensive project overview and execution instructions.
SlideShow.java – The final, polished Java source code.
SlideShow.jar – The standalone executable file.
/resources/ – All 5 copyright-free destination images.
/documentation/ – The Module 4 Test Case Template (.xlsx), containing TC-001-R (Revised Slideshow Test Case) and edge-case scenarios.
