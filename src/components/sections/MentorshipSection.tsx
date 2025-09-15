import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { useState } from "react";
import { createMentorship } from "@/services/mentorshipService";
import { UserCheck, Target, Trophy, MessageCircle } from "lucide-react";

const MentorshipSection = () => {
  const mentorshipFeatures = [
    {
      icon: UserCheck,
      title: "Expert Matching",
      description: "Advanced algorithm connects athletes with mentors based on sport, goals, and personality fit."
    },
    {
      icon: Target,
      title: "Goal Setting",
      description: "Structured milestone tracking and achievement planning to maximize athletic potential."
    },
    {
      icon: MessageCircle,
      title: "Direct Communication",
      description: "Secure messaging platform for ongoing guidance and support between mentors and athletes."
    },
    {
      icon: Trophy,
      title: "Success Tracking",
      description: "Monitor progress with detailed analytics and celebrate achievements together."
    }
  ];

  const [openForm, setOpenForm] = useState(false);
  const [mentorName, setMentorName] = useState("");
  const [menteeName, setMenteeName] = useState("");
  const [goals, setGoals] = useState("");
  const [submitting, setSubmitting] = useState(false);

  async function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    try {
      setSubmitting(true);
      await createMentorship({ mentorName, menteeName, goals, status: "PENDING" });
      setOpenForm(false);
      setMentorName("");
      setMenteeName("");
      setGoals("");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <section id="mentorship" className="py-24 relative overflow-hidden">
      <div className="absolute inset-0 bg-gradient-to-br from-primary/5 to-transparent" />
      
      <div className="container mx-auto px-4 relative z-10">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold mb-6 bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
            Mentorship Program
          </h2>
          <p className="text-xl text-muted-foreground max-w-3xl mx-auto">
            Connect with experienced athletes, coaches, and industry professionals who understand your journey and can guide you to success.
          </p>
        </div>

        <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-6 mb-16">
          {mentorshipFeatures.map((feature, index) => (
            <Card key={index} className="glass-card border-0 hover:shadow-[var(--shadow-elevated)] transition-all duration-300 scale-hover">
              <CardHeader className="text-center">
                <div className="w-16 h-16 mx-auto bg-gradient-to-br from-primary to-primary-glow rounded-xl flex items-center justify-center mb-4">
                  <feature.icon className="h-8 w-8 text-white" />
                </div>
                <CardTitle className="text-xl">{feature.title}</CardTitle>
              </CardHeader>
              <CardContent>
                <p className="text-muted-foreground text-center">{feature.description}</p>
              </CardContent>
            </Card>
          ))}
        </div>

        <div className="glass-card p-8 text-center">
          <h3 className="text-2xl font-semibold mb-4">Ready to find your mentor?</h3>
          <p className="text-muted-foreground mb-6 max-w-2xl mx-auto">
            Join our mentorship program and get paired with someone who can help accelerate your athletic career.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <Button onClick={() => setOpenForm(true)} size="lg" className="bg-gradient-to-r from-primary to-primary-glow">
              Find a Mentor
            </Button>
            <Button onClick={() => setOpenForm(true)} variant="outline" size="lg" className="glass-button">
              Become a Mentor
            </Button>
          </div>
        </div>

        <Dialog open={openForm} onOpenChange={setOpenForm}>
          <DialogContent>
            <DialogHeader>
              <DialogTitle>Mentorship Request</DialogTitle>
            </DialogHeader>
            <form onSubmit={onSubmit} className="space-y-4">
              <div className="space-y-2">
                <Label htmlFor="mentorName">Mentor Name</Label>
                <Input id="mentorName" value={mentorName} onChange={(e) => setMentorName(e.target.value)} required />
              </div>
              <div className="space-y-2">
                <Label htmlFor="menteeName">Mentee Name</Label>
                <Input id="menteeName" value={menteeName} onChange={(e) => setMenteeName(e.target.value)} required />
              </div>
              <div className="space-y-2">
                <Label htmlFor="goals">Goals</Label>
                <Textarea id="goals" value={goals} onChange={(e) => setGoals(e.target.value)} required />
              </div>
              <Button type="submit" disabled={submitting} className="w-full bg-gradient-to-r from-primary to-primary-glow">
                {submitting ? "Submitting..." : "Submit"}
              </Button>
            </form>
          </DialogContent>
        </Dialog>
      </div>
    </section>
  );
};

export default MentorshipSection;