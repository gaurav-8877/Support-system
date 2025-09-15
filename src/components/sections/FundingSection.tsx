import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Progress } from "@/components/ui/progress";
import { DollarSign, Users, Target, Zap } from "lucide-react";

const FundingSection = () => {
  const campaigns = [
    {
      id: 1,
      title: "Maria's Olympic Training Fund",
      sport: "Swimming",
      goal: 15000,
      raised: 12500,
      supporters: 89,
      daysLeft: 23,
      image: "🏊‍♀️"
    },
    {
      id: 2,
      title: "Youth Basketball Academy",
      sport: "Basketball",
      goal: 25000,
      raised: 8750,
      supporters: 156,
      daysLeft: 45,
      image: "🏀"
    },
    {
      id: 3,
      title: "Track & Field Equipment Fund",
      sport: "Athletics",
      goal: 8000,
      raised: 7200,
      supporters: 67,
      daysLeft: 12,
      image: "🏃‍♂️"
    }
  ];

  return (
    <section id="funding" className="py-24 bg-gradient-to-br from-backdrop to-background">
      <div className="container mx-auto px-4">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold mb-6 bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
            Crowdfunding Goals
          </h2>
          <p className="text-xl text-muted-foreground max-w-3xl mx-auto">
            Support talented athletes by contributing to their training, equipment, and competition needs. Every contribution makes a difference.
          </p>
        </div>

        <div className="grid lg:grid-cols-3 gap-8 mb-16">
          {campaigns.map((campaign) => {
            const progressPercentage = (campaign.raised / campaign.goal) * 100;
            
            return (
              <Card key={campaign.id} className="glass-card border-0 hover:shadow-[var(--shadow-elevated)] transition-all duration-300 scale-hover">
                <CardHeader>
                  <div className="text-4xl mb-4 text-center">{campaign.image}</div>
                  <CardTitle className="text-xl text-center">{campaign.title}</CardTitle>
                  <p className="text-sm text-center text-muted-foreground">{campaign.sport}</p>
                </CardHeader>
                <CardContent className="space-y-4">
                  <div className="space-y-2">
                    <div className="flex justify-between text-sm">
                      <span className="text-muted-foreground">Progress</span>
                      <span className="font-medium">{progressPercentage.toFixed(0)}%</span>
                    </div>
                    <Progress value={progressPercentage} className="h-3" />
                    <div className="flex justify-between text-sm">
                      <span className="font-semibold">${campaign.raised.toLocaleString()}</span>
                      <span className="text-muted-foreground">of ${campaign.goal.toLocaleString()}</span>
                    </div>
                  </div>
                  
                  <div className="flex justify-between items-center text-sm text-muted-foreground">
                    <div className="flex items-center">
                      <Users className="h-4 w-4 mr-1" />
                      {campaign.supporters} supporters
                    </div>
                    <div className="flex items-center">
                      <Target className="h-4 w-4 mr-1" />
                      {campaign.daysLeft} days left
                    </div>
                  </div>
                  
                  <Button className="w-full bg-gradient-to-r from-primary to-primary-glow">
                    <DollarSign className="mr-2 h-4 w-4" />
                    Support Now
                  </Button>
                </CardContent>
              </Card>
            );
          })}
        </div>

        <div className="glass-card p-8 text-center">
          <div className="grid md:grid-cols-3 gap-8 mb-8">
            <div className="text-center">
              <Zap className="h-12 w-12 mx-auto mb-4 text-primary" />
              <h3 className="text-lg font-semibold mb-2">Quick Setup</h3>
              <p className="text-muted-foreground">Create your funding campaign in minutes with our streamlined process.</p>
            </div>
            <div className="text-center">
              <Users className="h-12 w-12 mx-auto mb-4 text-success" />
              <h3 className="text-lg font-semibold mb-2">Community Support</h3>
              <p className="text-muted-foreground">Tap into our network of supporters who believe in athletic potential.</p>
            </div>
            <div className="text-center">
              <Target className="h-12 w-12 mx-auto mb-4 text-warning" />
              <h3 className="text-lg font-semibold mb-2">Goal Tracking</h3>
              <p className="text-muted-foreground">Monitor progress and celebrate milestones with real-time updates.</p>
            </div>
          </div>
          
          <Button size="lg" className="bg-gradient-to-r from-primary to-primary-glow">
            Start Your Campaign
          </Button>
        </div>
      </div>
    </section>
  );
};

export default FundingSection;