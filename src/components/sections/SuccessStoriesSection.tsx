import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { useState } from "react";
import { createNews } from "@/services/newsService";
import { Quote, ArrowRight } from "lucide-react";

const SuccessStoriesSection = () => {
  const stories = [
    {
      id: 1,
      name: "Alex Rodriguez",
      sport: "Boxing",
      achievement: "National Champion",
      quote: "The mentorship program changed my life. My mentor helped me believe in myself and provided the guidance I needed to reach the national level.",
      fundingReceived: "$12,000",
      mentorshipDuration: "2 years",
      image: "🥊"
    },
    {
      id: 2,
      name: "Sarah Chen",
      sport: "Gymnastics",
      achievement: "College Scholarship",
      quote: "Thanks to the funding support, I could afford proper training equipment and coaching. Now I'm competing at the collegiate level!",
      fundingReceived: "$18,500",
      mentorshipDuration: "18 months",
      image: "🤸‍♀️"
    },
    {
      id: 3,
      name: "Marcus Johnson",
      sport: "Track & Field",
      achievement: "Junior Olympics Qualifier",
      quote: "The community here is incredible. From funding my travel expenses to connecting me with elite coaches, PlayerCare made my dreams possible.",
      fundingReceived: "$8,200",
      mentorshipDuration: "1 year",
      image: "🏃‍♂️"
    }
  ];

  const [open, setOpen] = useState(false);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [submitting, setSubmitting] = useState(false);

  async function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    try {
      setSubmitting(true);
      await createNews({ title, content });
      setOpen(false);
      setTitle("");
      setContent("");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <section id="stories" className="py-24 relative overflow-hidden">
      <div className="absolute inset-0 bg-gradient-to-br from-success/5 to-transparent" />
      
      <div className="container mx-auto px-4 relative z-10">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold mb-6 bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
            Success Stories
          </h2>
          <p className="text-xl text-muted-foreground max-w-3xl mx-auto">
            Real athletes, real achievements. See how our platform has helped transform dreams into reality.
          </p>
        </div>

        <div className="grid lg:grid-cols-3 gap-8 mb-16">
          {stories.map((story) => (
            <Card key={story.id} className="glass-card border-0 hover:shadow-[var(--shadow-elevated)] transition-all duration-300 scale-hover">
              <CardContent className="p-8">
                <div className="text-center mb-6">
                  <div className="text-5xl mb-4">{story.image}</div>
                  <h3 className="text-xl font-semibold mb-1">{story.name}</h3>
                  <p className="text-muted-foreground mb-2">{story.sport}</p>
                  <div className="inline-block px-3 py-1 bg-gradient-to-r from-success to-success/80 text-success-foreground text-sm rounded-full">
                    {story.achievement}
                  </div>
                </div>
                
                <div className="relative mb-6">
                  <Quote className="absolute -top-2 -left-2 h-6 w-6 text-primary/30" />
                  <p className="text-muted-foreground italic pl-4">
                    "{story.quote}"
                  </p>
                </div>
                
                <div className="space-y-3 text-sm">
                  <div className="flex justify-between">
                    <span className="text-muted-foreground">Funding Received:</span>
                    <span className="font-semibold text-primary">{story.fundingReceived}</span>
                  </div>
                  <div className="flex justify-between">
                    <span className="text-muted-foreground">Mentorship Duration:</span>
                    <span className="font-semibold">{story.mentorshipDuration}</span>
                  </div>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>

        <div className="text-center">
          <div className="glass-card p-8 max-w-2xl mx-auto">
            <h3 className="text-2xl font-semibold mb-4">Ready to write your success story?</h3>
            <p className="text-muted-foreground mb-6">
              Join hundreds of athletes who have achieved their goals with our support.
            </p>
            <Button onClick={() => setOpen(true)} size="lg" className="bg-gradient-to-r from-primary to-primary-glow">
              Share Your Story
              <ArrowRight className="ml-2 h-4 w-4" />
            </Button>
          </div>
        </div>
      </div>
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Share Your Story</DialogTitle>
          </DialogHeader>
          <form onSubmit={onSubmit} className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="story-title">Title</Label>
              <Input id="story-title" value={title} onChange={(e) => setTitle(e.target.value)} required />
            </div>
            <div className="space-y-2">
              <Label htmlFor="story-content">Content</Label>
              <Textarea id="story-content" value={content} onChange={(e) => setContent(e.target.value)} required />
            </div>
            <Button disabled={submitting} type="submit" className="w-full bg-gradient-to-r from-primary to-primary-glow">{submitting ? "Submitting..." : "Submit"}</Button>
          </form>
        </DialogContent>
      </Dialog>
    </section>
  );
};



export default SuccessStoriesSection;