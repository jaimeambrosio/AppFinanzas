<%-- 
    Document   : sectionTimeLine
    Created on : 01/07/2016, 06:30:26 AM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="idSectionTimeline" class="cd-horizontal-timeline" style="display: none;" >   
    <div class="timeline">
        <div class="events-wrapper">
            <div class="events">
                <ol id="idSectionTimelineHeader" >
                    <li><a href="#0" data-date="01/01/2014" class="selected">16 Jan</a></li>
                    <li><a href="#0" data-date="01/01/2030">2030</a></li>
                </ol>
                <span style="display: none;" class="filling-line" aria-hidden="true"></span>

            </div> <!-- .events -->
        </div> <!-- .events-wrapper -->

        <ul class="cd-timeline-navigation">
            <li><a href="#0" class="prev inactive">Prev</a></li>
            <li><a href="#0" class="next">Next</a></li>
        </ul> 
    </div> <!-- .timeline -->

    <div class="events-content">
        <ol id="idSectionTimelineBody" >
            <li class="selected" data-date="01/01/2014">
                <h2>Horizontal Timeline</h2>
                <em>01/01/2014</em>
                <p>	
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illum praesentium officia, fugit recusandae ipsa, quia velit nulla adipisci? Consequuntur aspernatur at, eaque hic repellendus sit dicta consequatur quae, ut harum ipsam molestias maxime non nisi reiciendis eligendi! Doloremque quia pariatur harum ea amet quibusdam quisquam, quae, temporibus dolores porro doloribus.
                </p>
            </li>

            <li data-date="01/01/2030">
                <h2>Event title here</h2>
                <em>01/01/2030</em>
                <p>	
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illum praesentium officia, fugit recusandae ipsa, quia velit nulla adipisci? Consequuntur aspernatur at, eaque hic repellendus sit dicta consequatur quae, ut harum ipsam molestias maxime non nisi reiciendis eligendi! Doloremque quia pariatur harum ea amet quibusdam quisquam, quae, temporibus dolores porro doloribus.
                </p>
            </li>
        </ol>
    </div> <!-- .events-content -->
</section> 
