
# Project-NFC Development Report

Computer Science AP

**THIS SOFTWARE WAS PART OF A HIGH SCHOOL IN-CLASS ASSIGNMENT**

![Image 1](Aspose.Words.a08724df-0b08-4f63-856a-3c9155230d12.001.png)
COVID-19 had a significant impact on our lives, which we still continue to suffer from. Tourism has been one of the most impacted industries around the world, and the tourism industry in Japan is no exception. However in 2021, many businesses have started to reopen and many other restrictions are expected to follow suit, thanks to the hard work of the front-line workers and the vaccines manufactures. With our lives returning to the normal, it has become the perfect time for people to start their planning for their next vacation. My software, Project NFC, encourages people around the world to visit Japan, by showcasing the beauties of Japan and its culture, while also delivering COVID related facts for a safer trip. 

##Underlying Software Design##

The 2 factors, interests toward Japan and safeties of traveling, had to be accounted for in my software. Does are what the visitors are most concerned about. Therefore, my decision was to use simple maps and short articles derived from Wikipedia.org as the main features. 

I chose to use a single map instead of dozens of graphs, since many websites online take the graph approach, which I find to be challenging to comprehend at a single glance. While graphs are convenient in packing huge amounts of information, I wanted a solution that was both easy to understand and less space consuming. Having a single image that uses colored dots fulfills my expectations, rather than 47 graphs, one for each prefecture. 

Image above is a screenshot of the final product. The JPanel contains a map of Japan, with colored dots in the foreground to indicate the risks of visiting the prefecture. The risk is estimated from a value which is the average of the case numbers in the past 2 weeks divided by the population. If that value is above a certain threshold, the risk is determined to be moderate or high (0.00003, or average of 3 new cases in a population of 10,000 is considered high risk). By using colored dots, I have embraced the simplicity of the diagram, making the software easier for the user to understand. Even though I must note that those calculated “risk values” are lacking scientific evidence, I think it may be one of the factors that the users can consider in their trip planning process and also during their trip. 

The decision of deriving articles from Wikipedia.org has been made considering the accuracy of their information and the iterative development made by the community. Different approach may have been to write the articles by myself, which would have been much more time consuming and may also be limited in its credibility. Furthermore, another factor that lead to my decision is that many other APIs were paid or did not work web-based (Ex: requires the implementation of JavaScript). In contrast, API from Wikipedia.org is free to use, and is very responsive. 



![Image 2](Aspose.Words.a08724df-0b08-4f63-856a-3c9155230d12.002.png)
This is another screenshot from the final product. On the left side, there are short articles that describe the place, along with a couple images to gain a better understanding. As I have said, the articles are derived from wikipedia.org, and the user can read more about the place by clicking on “(From Wikipedia)”. The other hyperlink, “See in Google map”, opens Google map in the browser. The map on the right side gives the user a brief understanding of where the place is located. The images are chosen by me, and were downloaded from [HERE](https://www.photo-ac.com/). The images were all free to use. I had to downsize or upscale some of the images to make them fit into the GUI.

In behind the GUIs, I had been working hard on making the software as generic as possible. Since I plan on expanding on this software for not only Japan but also other countries, I used Java features such as inheritance and abstract classes so that I can reuse most of the classes from this program. I have also implemented an easy-injection feature for the language files, avoiding the hard-coding of texts for each language option. Currently, the program supports English and partially, Japanese. 

##Conclusion##

As for the conclusion, I consider that my program and its main two features have been successful in addressing the proposed issue. By combining the ideas of case number dash board and a guidebook, it acts as a tool for the people around the world to know more about Japan, and to also consider about their next trip. Unfortunately, it is only a *suggesting* tool, and is *only* combining the features found online, so it has very limited amounts of originality. In future programs, I should combine other studies, such as business, in order to address the issue around the idea of market-in, and not product-in. Also, this program has its major problem in gaining more users, so cooperating with actual businesses and listening to the consumers will be my next goal. Nonetheless, I strongly wish that people who are planning their next vacation to stop by and take a peek at my software; and potentially, have a safe and exciting trip in Japan.

##Future Development##

- Improving the accuracy in risk prediction.
  - May be addressed by using machine learning and using a data model to give a prediction. 
- Reinforcing the translator section
  - ` `Using paid API services such as Google Translate API is an option.
- Expanding the platform to gain more users
  - Shifting development towards web-base and smartphone users can be a step forward. 

Huge thanks to our Computer Science teacher Mr. Cheng for his support, and also to my classmates.
Special thanks to my parents, my sister, and my best friend, Nic. :)


