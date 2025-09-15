import Header from "@/components/layout/Header";
import Footer from "@/components/layout/Footer";
import HeroSection from "@/components/sections/HeroSection";
import MentorshipSection from "@/components/sections/MentorshipSection";
import FundingSection from "@/components/sections/FundingSection";
import SuccessStoriesSection from "@/components/sections/SuccessStoriesSection";
import UserRolesSection from "@/components/sections/UserRolesSection";

const Index = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-backdrop to-background">
      <Header />
      <main>
        <HeroSection />
        <MentorshipSection />
        <FundingSection />
        <SuccessStoriesSection />
        <UserRolesSection />
      </main>
      <Footer />
    </div>
  );
};

export default Index;
